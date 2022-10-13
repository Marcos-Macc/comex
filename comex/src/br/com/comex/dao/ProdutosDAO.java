package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.StatusCategoria;

public class ProdutosDAO {
	private Connection c;
	
	public ProdutosDAO(Connection c) { 
		this.c = c;
	}
	
	public List<Produto> listaProduto(int id){
		try {
			List<Produto> p = new ArrayList<Produto>();
			String sql = "SELECT p.id, p.nome nomeProd, p.descricao, p.preco_unitario, p.quantidade_estoque,"
					+ "p.categoria_ID, c.id IDCAT, p.TIPO, c.nome nomeCat, c.status from comex.produto p "
					+ "INNER JOIN comex.categoria c on c.id = p.categoria_ID ";
			if(id>0) sql+= "WHERE p.id =? ";
			sql+=" order by p.ID";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				if(id>0) pstm.setInt(1, id);
				pstm.execute();
				transformarResultSetEmProduto(p,pstm);
			}
			return p;
			
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public int insereProduto(Produto p) {
		int resultado = 0;
		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.PRODUTO(NOME,DESCRICAO,PRECO_UNITARIO,"
					+ "QUANTIDADE_ESTOQUE,CATEGORIA_ID,TIPO)VALUES(?,?,?,?,?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql,colunaParaRetornar)){
				pstm.setString(1,p.getNome());
				pstm.setString(2,p.getDescricao());
				pstm.setDouble(3,p.getPrecoUnitario());
				pstm.setInt(4,p.getQuantidade());
				pstm.setInt(5,p.getCategoria().getId());
				pstm.setString(6,p.getTIPO());
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					while(rs.next()) {
						resultado=rs.getInt(1);
					}
				}
			}
			return resultado;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int atualizaProduto(Produto p) {
		int resultado = 0;
		try {
			String sql = "UPDATE comex.produto SET nome=?,DESCRICAO=?,PRECO_UNITARIO=?,"
					+ "QUANTIDADE_ESTOQUE=?,CATEGORIA_ID=?,TIPO=? "
					+ "WHERE id=?";
			try(PreparedStatement pstm = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1,p.getNome());
				pstm.setString(2,p.getDescricao());
				pstm.setDouble(3,p.getPrecoUnitario());
				pstm.setInt(4,p.getQuantidade());
				pstm.setInt(5,p.getCategoria().getId());
				pstm.setString(6,p.getTIPO());
				pstm.setInt(7,p.getId());
				
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			resultado = -1;
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int deletaProduto(Produto p) {
		int resultado = 0;
		try {
			String sql = "DELETE from comex.produto where id = ?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setInt(1, p.getId());
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public void transformarResultSetEmProduto(List<Produto> p, PreparedStatement pstm) throws SQLException {
		try(ResultSet rs = pstm.getResultSet()){
			while(rs.next()) {
				Categoria cat = new Categoria(rs.getInt("IDCAT"), rs.getString("nomeCat"), StatusCategoria.valueOf(rs.getString("status")));
				Produto pro = new Produto(rs.getInt("ID"), rs.getString("nomeProd"), 
						rs.getString("descricao"), rs.getDouble("preco_unitario"), 
						rs.getInt("quantidade_estoque"), 
						cat, rs.getString("TIPO"));
	/*			"SELECT p.id, p.nome nomeProd, p.descricao, p.preco_unitario, p.quantidade_estoque,"
				+ "p.categoria_ID, p.TIPO, c.nome nomeCat, c.status from comex.produto p "
				+ "INNER JOIN comex.categoria c on c.id = p.categoria_ID order by ID";
				*/p.add(pro);
			}
		}
	}	

}

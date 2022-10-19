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

public class CategoriasDAO {
	private Connection c;
	
	public CategoriasDAO(Connection c) {
		this.c = c;
	}
	
	public List<Categoria> listaCategoria(int id){
		try {
			List<Categoria> cat = new ArrayList<Categoria>();
			String sql = "SELECT id, nome, status from comex.Categoria ";
			
			if(id>0) sql+= "WHERE id =? ";
			
			sql+= " order by ID";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				if(id>0) pstm.setInt(1, id);
				pstm.execute();
				transformarResultSetEmCategoria(cat,pstm);
			}
			return cat;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int insereCategoria(Categoria cat) {
		int resultado = 0;
		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.Categoria(NOME,STATUS)VALUES(?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql, colunaParaRetornar)){
				pstm.setString(1, cat.getNome());
				pstm.setString(2, cat.getStatus().getDescricao());
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					while(rs.next()) {
						resultado= (int) rs.getLong(1);
					}
				}
			}
			return resultado;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int atualizaCategoria(Categoria cat) {
		int resultado = 0;
		try {
			String sql = "UPDATE comex.Categoria SET nome=?,STATUS=?"
					+ "WHERE id=?";
			try(PreparedStatement pstm = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1,cat.getNome());
				pstm.setString(2,cat.getStatus().getDescricao());
				pstm.setInt(3,cat.getId());
				
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			resultado = -1;
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int deletaCategoria(Categoria cat) {
		int resultado = 0;
		try {
			String sql = "DELETE from comex.Categoria where id = ?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setInt(1, cat.getId());
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int deletaCategoriasInativas() {
		int resultado = 0;
		try {
			String sql = "DELETE FROM comex.categoria WHERE upper(STATUS) = 'INATIVA'";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public void transformarResultSetEmCategoria(List<Categoria> cat, PreparedStatement pstm) throws SQLException {
		try(ResultSet rs = pstm.getResultSet()){
			while(rs.next()) {
				Categoria ct = new Categoria(rs.getInt("ID"), rs.getString("nome"), 
						StatusCategoria.valueOf(rs.getString("status")));
				cat.add(ct);
			}
		}
	}
}

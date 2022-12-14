package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class CategoriasDAO {
	private Connection c;
	
	public CategoriasDAO(Connection c) {
		this.c = c;
	}
	
	public List<Categoria> listaTodos(){
		try {
			List<Categoria> cat = new ArrayList<Categoria>();
			String sql = "SELECT id, nome, status from comex.Categoria order by ID";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.execute();
				transformarResultSetEmCategoria(cat,pstm);
			}
			return cat;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Categoria listaUm(Long id){
		try {
			Categoria cat = null;
			String sql = "SELECT id, nome, status from comex.Categoria WHERE id =? ";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, id);
				pstm.execute();
				try(ResultSet rs = pstm.getResultSet()){
					if(rs.next()) {
						cat = new Categoria(rs.getLong("ID"), rs.getString("nome"), 
								StatusCategoria.valueOf(rs.getString("status")));
					}
				}
			}
			return cat;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insereCategoria(Categoria cat) {
		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.Categoria(NOME,STATUS)VALUES(?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql, colunaParaRetornar)){
				pstm.setString(1, cat.getNome());
				pstm.setString(2, cat.getStatus().getDescricao());
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					if(rs.next()) {
						cat.setId(rs.getLong(1));
					}
				}
			}
			
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
				pstm.setLong(3,cat.getId());
				
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
				pstm.setLong(1, cat.getId());
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
				Categoria ct = new Categoria(rs.getLong("ID"), rs.getString("nome"), 
						StatusCategoria.valueOf(rs.getString("status")));
				cat.add(ct);
			}
		}
	}
}
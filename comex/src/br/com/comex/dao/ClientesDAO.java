package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.siglaEstado;

public class ClientesDAO {
	private Connection c;
	
	public ClientesDAO(Connection c) {
		this.c = c;
	}
	
	public List<Cliente> listaTodos(){
		try {
			List<Cliente> cli = new ArrayList<Cliente>();
			String sql = "SELECT id, nome, cpf, telefone, rua, numero, complemento,"
					+ "bairro, cidade, uf from comex.cliente order by ID";

			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.execute();
				transformarResultSetEmCliente(cli,pstm);
			}
			return cli;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente listaUm(Long id){
		try {
			Cliente cli = null;
			String sql = "SELECT id, nome, cpf, telefone, rua, numero, complemento,"
					+ "bairro, cidade, uf from comex.cliente WHERE id =? "; 

			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, id);
				pstm.execute();
				try(ResultSet rs = pstm.getResultSet()){
					while(rs.next()) {
						cli = new Cliente(rs.getLong("ID"), rs.getString("nome"), 
								rs.getString("cpf"), rs.getString("telefone"), 
								rs.getString("rua"), rs.getString("numero"), 
								rs.getString("complemento"), rs.getString("bairro"),
								rs.getString("cidade"), siglaEstado.valueOf(rs.getString("uf")));
					}
				}
			}
			return cli;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insereCliente(Cliente cli) {

		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.CLIENTE(nome, cpf, telefone, rua, numero, complemento,"
					+ "bairro, cidade, uf)VALUES(?,?,?,?,?,?,?,?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql,colunaParaRetornar)){
				pstm.setString(1,cli.getNome());
				pstm.setString(2,cli.getCpf());
				pstm.setString(3,cli.getTelefone());
				pstm.setString(4,cli.getRua());
				pstm.setString(5,cli.getNumero());
				pstm.setString(6,cli.getComplemento());
				pstm.setString(7,cli.getBairro());
				pstm.setString(8,cli.getCidade());
				pstm.setString(9,cli.getEstado().toString());
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					if(rs.next()) {
						cli.setId(rs.getLong(1));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int atualizaCliente(Cliente cli) {
		int resultado = 0;
		try {
			String sql = "UPDATE comex.cliente SET nome=?,cpf=?,telefone=?,"
					+ "rua=?,numero=?,complemento=?,bairro=?,cidade=?, UF =? "
					+ "WHERE id=?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setString(1,cli.getNome());
				pstm.setString(2,cli.getCpf());
				pstm.setString(3,cli.getTelefone());
				pstm.setString(4,cli.getRua());
				pstm.setString(5,cli.getNumero());
				pstm.setString(6,cli.getComplemento());
				pstm.setString(7,cli.getBairro());
				pstm.setString(8,cli.getCidade());
				pstm.setString(9,cli.getEstado().toString());
				pstm.setLong(10,cli.getId());
				
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			resultado = -1;
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int deletaCliente(Cliente cli) {
		int resultado = 0;
		try {
			String sql = "DELETE from comex.cliente where id = ?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, cli.getId());
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public void transformarResultSetEmCliente(List<Cliente> p, PreparedStatement pstm) throws SQLException {
		try(ResultSet rs = pstm.getResultSet()){
			while(rs.next()) {
				Cliente cli = new Cliente(rs.getLong("ID"), rs.getString("nome"), 
						rs.getString("cpf"), rs.getString("telefone"), 
						rs.getString("rua"), rs.getString("numero"), 
						rs.getString("complemento"), rs.getString("bairro"),
						rs.getString("cidade"), siglaEstado.valueOf(rs.getString("uf")));
				p.add(cli);
			}
		}
	}
}
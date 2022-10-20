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
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.siglaEstado;

public class PedidosDAO {
	private Connection c;
	
	public PedidosDAO(Connection c) {
		this.c = c;
	}
	
	public List<Pedido> listaTodos(){
		try {
			List<Pedido> p = new ArrayList<Pedido>();
			String sql = "SELECT pe.id, pe.data, pe.Cliente_ID, "
					+ "cli.id IDCliente, cli.nome, cli.cpf, cli.telefone, cli.rua, cli.numero, cli.complemento,"
					+ "cli.bairro, cli.cidade, cli.uf from comex.Pedido pe "
					+ "inner join comex.cliente cli on cli.id = pe.cliente_ID order by pe.ID";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.execute();
				transformarResultSetEmPedido(p,pstm);
			}
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Pedido listaUm(Long id){
		try {
			Pedido p = null;
			String sql = "SELECT pe.id, pe.data, pe.Cliente_ID, "
					+ "cli.id IDCliente, cli.nome, cli.cpf, cli.telefone, cli.rua, cli.numero, cli.complemento,"
					+ "cli.bairro, cli.cidade, cli.uf from comex.Pedido pe "
					+ "inner join comex.cliente cli on cli.id = pe.cliente_ID WHERE pe.id =? ";

			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, id);
				pstm.execute();
				try(ResultSet rs = pstm.getResultSet()){
					if(rs.next()) {
						Cliente cli = new Cliente(rs.getLong("ID"), rs.getString("nome"), 
								rs.getString("cpf"), rs.getString("telefone"), 
								rs.getString("rua"), rs.getString("numero"), 
								rs.getString("complemento"), rs.getString("bairro"),
								rs.getString("cidade"), siglaEstado.valueOf(rs.getString("uf")));
						p = new Pedido(rs.getLong("ID"), rs.getDate("data"),cli);
					}
				}
			}
			return p;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void inserePedido(Pedido p) {
		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.Pedido(DATA,CLIENTE_ID)"
					+ " VALUES(?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql,colunaParaRetornar)){
				pstm.setDate(1, p.getData());
				pstm.setLong(2, p.getCliente().getId());
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					while(rs.next()) {
						p.setId(rs.getLong(1));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int atualizaPedido(Pedido p) {
		int resultado = 0;
		try {
			String sql = "UPDATE comex.Pedido SET data=?,CLIENTE_ID=?"
					+ "WHERE id=?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setDate(1,p.getData());
				pstm.setLong(2,p.getCliente().getId());
				pstm.setDouble(3,p.getId());
				
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			resultado = -1;
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int deletaPedido(Pedido p) {
		int resultado = 0;
		try {
			String sql = "DELETE from comex.pedido where id = ?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, p.getId());
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public void transformarResultSetEmPedido(List<Pedido> p, PreparedStatement pstm) throws SQLException {
		try(ResultSet rs = pstm.getResultSet()){
			while(rs.next()) {
				Cliente cli = new Cliente(rs.getLong("ID"), rs.getString("nome"), 
						rs.getString("cpf"), rs.getString("telefone"), 
						rs.getString("rua"), rs.getString("numero"), 
						rs.getString("complemento"), rs.getString("bairro"),
						rs.getString("cidade"), siglaEstado.valueOf(rs.getString("uf")));
				Pedido pe = new Pedido(rs.getLong("ID"), rs.getDate("data"),cli);
				p.add(pe);
			}
		}
	}
}

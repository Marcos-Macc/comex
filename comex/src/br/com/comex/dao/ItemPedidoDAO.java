package br.com.comex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.StatusCategoria;
import br.com.comex.modelo.tipoDescontoPedido;

public class ItemPedidoDAO {
	private Connection c;
	
	public ItemPedidoDAO(Connection c) {
		this.c = c;
	}
	
	public List<ItemPedido> listaTodos(){
		try {
			List<ItemPedido> ip = new ArrayList<ItemPedido>();
			String sql = "SELECT ip.id idIP,ip.preco_unitario preco_unitarioIP, ip.quantidade quantidadeIP,"
					+ "ip.PRODUTO_ID, ip.PEDIDO_ID, ip.DESCONTO DESCONTOIP, ip.TIPO_DESCONTO TIPO_DESCONTOIP from comex.Item_Pedido ip order by ip.ID";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.execute();
				transformarResultSetEmItemPedido(ip,pstm);
			}
			return ip;
			 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ItemPedido listaUm(Long id){
		try {
			ItemPedido ip = null;
			String sql = "SELECT ip.id idIP,ip.preco_unitario preco_unitarioIP, ip.quantidade quantidadeIP,"
					+ "ip.PRODUTO_ID, ip.PEDIDO_ID, ip.DESCONTO DESCONTOIP, ip.TIPO_DESCONTO TIPO_DESCONTOIP "
					+ "from comex.Item_Pedido ip WHERE ip.id =? ";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, id);
				pstm.execute();
				try(ResultSet rs = pstm.getResultSet()){
					if(rs.next()) {
						Produto pro = new ProdutosDAO(c).listaUm(rs.getLong("PRODUTO_ID"));
						Pedido ped = new PedidosDAO(c).listaUm(rs.getLong("PEDIDO_ID"));
						ItemPedido itp = new ItemPedido(rs.getLong("IDIP"), rs.getInt("quantidadeIP"),
								pro,ped,rs.getDouble("descontoIP"),
								tipoDescontoPedido.valueOf(rs.getString("TIPO_DESCONTOIP")));
					}
				}
			}
			return ip;
			 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insereItemPedido(ItemPedido ip) {
		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.Item_Pedido(PRECO_UNITARIO,QUANTIDADE,"
					+ "PRODUTO_ID,PEDIDO_ID,DESCONTO,TIPO_DESCONTO)"
					+ "VALUES(?,?,?,?,?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql,colunaParaRetornar)){
				pstm.setDouble(1, ip.getPrecoUnitario());
				pstm.setInt(2, ip.getQuantidade());
				pstm.setLong(3, ip.getProduto().getId());
				pstm.setLong(4, ip.getPedido().getId());
				pstm.setDouble(5, ip.getDesconto());
				pstm.setString(6, ip.getTipoDesconto().toString());
				
				pstm.execute();
				try(ResultSet rs = pstm.getGeneratedKeys()){
					if(rs.next()) {
						ip.setId(rs.getLong(1));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int atualizaItemPedido(ItemPedido ip) {
		int resultado = 0;
		try {
			String sql = "UPDATE comex.Item_Pedido SET PRECO_UNITARIO=?,QUANTIDADE=?,"
					+ "PRODUTO_ID=?,"
					+ "PEDIDO_ID=?,DESCONTO=?,TIPO_DESCONTO=? "
					+ "WHERE id=?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setDouble(1,ip.getPrecoUnitario());
				pstm.setInt(2,ip.getQuantidade());
				pstm.setLong(3,ip.getProduto().getId());
				pstm.setLong(4,ip.getPedido().getId());
				pstm.setDouble(5,ip.getDesconto());
				pstm.setString(6,ip.getTipoDesconto().toString());
				pstm.setLong(7,ip.getId());
				
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			resultado = -1;
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public int deletaItemPedido(ItemPedido ip) {
		int resultado = 0;
		try {
			String sql = "DELETE from comex.Item_Pedido where id = ?";
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				pstm.setLong(1, ip.getId());
				pstm.execute();
				resultado = 1;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public void transformarResultSetEmItemPedido(List<ItemPedido> ip, PreparedStatement pstm) throws SQLException {
		try(ResultSet rs = pstm.getResultSet()){
			while(rs.next()) {
				Produto pro = new ProdutosDAO(c).listaUm(rs.getLong("PRODUTO_ID"));
				Pedido ped = new PedidosDAO(c).listaUm(rs.getLong("PEDIDO_ID"));
				ItemPedido itp = new ItemPedido(rs.getLong("IDIP"), rs.getInt("quantidadeIP"),
						pro,ped,rs.getDouble("descontoIP"),
						tipoDescontoPedido.valueOf(rs.getString("TIPO_DESCONTOIP")));
				ip.add(itp);
			}
		}
	}
}
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
	
	public List<ItemPedido> listaItemPedido(int id){
		try {
			List<ItemPedido> ip = new ArrayList<ItemPedido>();
			String sql = "SELECT ip.id idIP,ip.preco_unitario preco_unitarioIP, ip.quantidade quantidadeIP,"
					+ "ip.PRODUTO_ID, ip.PEDIDO_ID, ip.DESCONTO DESCONTOIP, ip.TIPO_DESCONTO TIPO_DESCONTOIP "
					+ "from comex.Item_Pedido ip ";
			if(id>0) sql+= "WHERE ip.id =? ";
			sql+=" order by ip.ID";
			
			try(PreparedStatement pstm = c.prepareStatement(sql)){
				if(id>0) pstm.setInt(1, id);
				pstm.execute();
				transformarResultSetEmItemPedido(ip,pstm);
			}
			return ip;
			 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int insereItemPedido(ItemPedido ip) {
		int resultado = 0;
		try {
			String[] colunaParaRetornar = { "id" };
			String sql = "INSERT INTO comex.Item_Pedido(PRECO_UNITARIO,QUANTIDADE,"
					+ "PRODUTO_ID,PEDIDO_ID,DESCONTO,TIPO_DESCONTO)"
					+ "VALUES(?,?,?,?,?,?)";
			try(PreparedStatement pstm = c.prepareStatement(sql,colunaParaRetornar)){
				pstm.setDouble(1, ip.getPrecoUnitario());
				pstm.setInt(2, ip.getQuantidade());
				pstm.setInt(3, ip.getProduto().getId());
				pstm.setInt(4, ip.getPedido().getId());
				pstm.setDouble(5, ip.getDesconto());
				pstm.setString(6, ip.getTipoDesconto().toString());
				
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
				pstm.setInt(3,ip.getProduto().getId());
				pstm.setInt(4,ip.getPedido().getId());
				pstm.setDouble(5,ip.getDesconto());
				pstm.setString(6,ip.getTipoDesconto().toString());
				pstm.setInt(7,ip.getId());
				
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
				pstm.setInt(1, ip.getId());
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
				List<Produto> pro = new ProdutosDAO(c).listaProduto(rs.getInt("PRODUTO_ID"));
				List<Pedido> ped = new PedidosDAO(c).listaPedido(rs.getInt("PEDIDO_ID"));
				ItemPedido itp = new ItemPedido(rs.getInt("IDIP"), rs.getInt("quantidadeIP"),
						pro.get(0),ped.get(0),rs.getDouble("descontoIP"),
						tipoDescontoPedido.valueOf(rs.getString("TIPO_DESCONTOIP")));
				ip.add(itp);
			}
		}
	}
}

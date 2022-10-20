package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.ProdutosDAO;
import br.com.comex.dao.PedidosDAO;
import br.com.comex.dao.ItemPedidoDAO;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.ProdutoIsento;
import br.com.comex.modelo.tipoDescontoPedido;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.ItemPedido;

public class MainTestaItemPedidoDAO {

	public static void main(String[] args) {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		ItemPedidoDAO ipDAO = new ItemPedidoDAO(c);
		List<Produto> pro = new ProdutosDAO(c).listaTodos();
		List<Pedido> ped = new PedidosDAO(c).listaTodos();
		
		
		
		
		ItemPedido itemPedido1 = new ItemPedido(11, pro.get(1), ped.get(0), 0, tipoDescontoPedido.QUANTIDADE);
		ItemPedido itemPedido2 = new ItemPedido(11, pro.get(0), ped.get(1), 0, tipoDescontoPedido.NENHUM);
		ItemPedido itemPedido3 = new ItemPedido(1, pro.get(0), ped.get(0), 0, tipoDescontoPedido.QUANTIDADE);
		ItemPedido itemPedido4 = new ItemPedido(11, pro.get(1), ped.get(1), 0, tipoDescontoPedido.PROMOCAO);

		ipDAO.insereItemPedido(itemPedido1);
		ipDAO.insereItemPedido(itemPedido2);
		ipDAO.insereItemPedido(itemPedido3);
		ipDAO.insereItemPedido(itemPedido4);

		List<ItemPedido> lcat = ipDAO.listaTodos();
		for (ItemPedido c1 : lcat) {
			System.out.println(c1.toString());
		}
		itemPedido1.setQuantidade(9999);
		ipDAO.atualizaItemPedido(itemPedido1);
		ipDAO.deletaItemPedido(itemPedido1);
		conF.fechaConexao(c);

	}

}

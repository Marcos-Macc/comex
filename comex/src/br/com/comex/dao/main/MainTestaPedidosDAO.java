package br.com.comex.dao.main;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import br.com.comex.dao.ClientesDAO;
import br.com.comex.dao.PedidosDAO;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.Pedido;

public class MainTestaPedidosDAO {

	public static void main(String[] args) {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		PedidosDAO pedDAO = new PedidosDAO(c);
		List<Cliente> cli = new ClientesDAO(c).listaCliente(0);
		
		Pedido pedido1 = new Pedido(Date.valueOf(LocalDate.now()), cli.get(0));
		Pedido pedido2 = new Pedido(Date.valueOf(LocalDate.now()), cli.get(0));
		Pedido pedido3 = new Pedido(Date.valueOf(LocalDate.now()), cli.get(1));
		
		pedido1.setId(pedDAO.inserePedido(pedido1));
		pedido2.setId(pedDAO.inserePedido(pedido2));
		pedido3.setId(pedDAO.inserePedido(pedido3));

		List<Pedido> lcat = pedDAO.listaPedido(0);
		for (Pedido c1 : lcat) {
			System.out.println(c1.toString());
		}
		pedido1.setData(Date.valueOf(LocalDate.now()));
		pedDAO.atualizaPedido(pedido1);
		pedDAO.deletaPedido(pedido1);
		
		
		conF.fechaConexao(c);

	}

}

package br.com.comex.csv;

import java.io.IOException;
import java.util.List;

public class PedidoMaisBaratoEMaisCaro {

	public static void main(String[] args) throws IOException {
		LeitorPedidosCsv lpc = new LeitorPedidosCsv();
		List<PedidoCsv> listaPedido = lpc.leituraPedidosCsv();
		double pedidoMaisBarato = 0;
		double pedidoMaisCaro = 0;
		listaPedido.sort( (l1, l2) -> Double.compare(Double.parseDouble(l1.getPreco())*Integer.parseInt(l1.getQuantidade()), Double.parseDouble(l2.getPreco())*Integer.parseInt(l2.getQuantidade())));

		pedidoMaisBarato = Double.parseDouble(listaPedido.get(0).getPreco())*Integer.parseInt(listaPedido.get(0).getQuantidade());
		pedidoMaisCaro = Double.parseDouble(listaPedido.get(listaPedido.size()-1).getPreco())*Integer.parseInt(listaPedido.get(listaPedido.size()-1).getQuantidade());
		System.out.println("Pedido mais barato: R$"+String.format("%,.2f",pedidoMaisBarato)+ " ("+listaPedido.get(0).getProduto()+")");
		System.out.println("Pedido mais caro: R$"+String.format("%,.2f",pedidoMaisCaro)+ " ("+listaPedido.get(listaPedido.size()-1).getProduto()+")");
	}

}

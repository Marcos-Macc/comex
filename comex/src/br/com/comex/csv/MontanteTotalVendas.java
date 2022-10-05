package br.com.comex.csv;

import java.io.IOException;
import java.util.List;

public class MontanteTotalVendas {

	public static void main(String[] args) throws IOException {
		LeitorPedidosCsv lpc = new LeitorPedidosCsv();
		List<PedidoCsv> listaPedido = lpc.leituraPedidosCsv();
		double totalMontanteVendas = 0;
		listaPedido.sort( (l1, l2) -> {
			String cat1 = l1.getCategoria();
			String cat2 = l2.getCategoria();
			return cat1.compareTo(cat2);
		});
		for (PedidoCsv pedidoCsv : listaPedido) {
			totalMontanteVendas+=(Double.parseDouble(pedidoCsv.getQuantidade())*Double.parseDouble(pedidoCsv.getPreco()));
		}
		System.out.println("Montante de vendas: "+totalMontanteVendas);


	}
}

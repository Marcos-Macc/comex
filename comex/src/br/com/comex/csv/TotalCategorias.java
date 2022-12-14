package br.com.comex.csv;

import java.io.IOException;
import java.util.List;

public class TotalCategorias {
	public static void main(String[] args) throws IOException {
		LeitorPedidosCsv lpc = new LeitorPedidosCsv();
		List<PedidoCsv> listaPedido = lpc.leituraPedidosCsv();
		int totalCategorias = 0;
		listaPedido.sort( (l1, l2) -> {
			String cat1 = l1.getCategoria();
			String cat2 = l2.getCategoria();
			return cat1.compareTo(cat2);
		});
		String auxiliar = "";
		for (PedidoCsv pedidoCsv : listaPedido) {
			if(!auxiliar.equals(pedidoCsv.getCategoria())) {
				auxiliar = pedidoCsv.getCategoria();
				totalCategorias++;
			}
		}
		System.out.println("Total de categorias: "+totalCategorias);

	}
}

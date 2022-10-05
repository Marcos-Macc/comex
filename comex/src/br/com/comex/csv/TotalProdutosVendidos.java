package br.com.comex.csv;

import java.io.IOException;
import java.util.List;

public class TotalProdutosVendidos {
	public static void main(String[] args) throws IOException {
		LeitorPedidosCsv lpc = new LeitorPedidosCsv();
		List<PedidoCsv> listaPedido = lpc.leituraPedidosCsv();
		int totalProdutosVendidos = 0;
		for (PedidoCsv pedidoCsv : listaPedido) {
			totalProdutosVendidos+=Integer.parseInt(pedidoCsv.getQuantidade());
		}
		System.out.println("Total de produtos vendidos: "+totalProdutosVendidos);
		
	}
	/*
	 Crie uma classe `TotalProdutosVendidos` que calcula, a partir da `List<PedidoCsv>` criada a 
	 partir do arquivo `pedidos.csv`, a soma das quantidades de produtos vendidos.

Imprima o total de produtos vendidos da seguinte forma:

```
Total de produtos vendidos: 35
```
	 */
}

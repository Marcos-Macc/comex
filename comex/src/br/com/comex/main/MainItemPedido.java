package br.com.comex.main;

import java.sql.Date;
import java.time.LocalDate;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ComexException;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.ProdutoIsento;
import br.com.comex.modelo.StatusCategoria;
import br.com.comex.modelo.siglaEstado;
import br.com.comex.modelo.tipoDescontoPedido;

public class MainItemPedido {
	public static void main(String[] args) {
		Cliente ana = new Cliente("Anna Paula", "123.123.123-89", "(56)99987-1234", "Av Batatinha", "123A", "",
				"bairro", "Conserva", siglaEstado.PR);
		Cliente eli = new Cliente("Elisa Beatriz", "45645645689", "555555-5555", "Av Batata", "5x", " bl 1", "Camões",
				"Cozido", siglaEstado.PR);
		Cliente gabi = new Cliente("Gabriela Duarte", "789.789.789.89", "11 99999-9999", "Av Batatão", "777", "",
				"Lima", "Assado", siglaEstado.PR);

		Pedido pedido1 = new Pedido(Date.valueOf(LocalDate.now()), ana);
		Pedido pedido2 = new Pedido(Date.valueOf(LocalDate.now()), eli);
		Pedido pedido3 = new Pedido(Date.valueOf(LocalDate.now()), gabi);

		Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
		Categoria cat3 = new Categoria("LIVROS", StatusCategoria.ATIVA);

		Produto produto1 = new Produto("Notebook Samsung", "", 3523.00, 1, cat1, "NAO_ISENTO");
		Produto produto2 = new ProdutoIsento("Clean Arquiteture", "", 102.90, 2, cat3,"ISENTO");
		Produto produto3 = new Produto("Monitor Dell 27", "", 1889.00, 3, cat1,"NAO_ISENTO");
		

		ItemPedido itemPedido1 = new ItemPedido(11, produto2, pedido3, 0, tipoDescontoPedido.QUANTIDADE);
		ItemPedido itemPedido2 = new ItemPedido(11, produto3, pedido2, 0, tipoDescontoPedido.NENHUM);
		ItemPedido itemPedido3 = new ItemPedido(1, produto2, pedido3, 0, tipoDescontoPedido.QUANTIDADE);
		ItemPedido itemPedido4 = new ItemPedido(11, produto1, pedido1, 0, tipoDescontoPedido.PROMOCAO);
		
		System.out.println(itemPedido1.imprimirInformacoes());
		System.out.println(itemPedido2.imprimirInformacoes());
		System.out.println(itemPedido3.imprimirInformacoes());
		System.out.println(itemPedido4.imprimirInformacoes());
		System.out.println("-------------------------------");
		System.out.println(itemPedido1.toString());
		System.out.println(itemPedido2.toString());
		System.out.println(itemPedido3.toString());
		System.out.println(itemPedido4.toString());
	}
}

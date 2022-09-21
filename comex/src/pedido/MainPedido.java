package pedido;

import java.time.LocalDate;
import java.sql.Date;

import cliente.Cliente;

public class MainPedido {
	public static void main(String[] args) {
		Cliente ana = new Cliente("Anna Paula", "123.123.123-89", "(56)99987-1234", "Av Batatinha", "123A", "", "bairro", "Conserva", "Pote");
		Cliente eli = new Cliente("Elisa Beatriz", "45645645689", "5555-5555", "Av Batata", "5x", " bl 1", "Camões", "Cozido", "PN");
		Cliente gabi = new Cliente("Gabriela Duarte", "789.789.789.89", "11 99999-9999", "Av Batatão", "777", "", "Lima", "Assado", "CH");
		
		Pedido pedido1 = new Pedido(Date.valueOf(LocalDate.now()), ana);
		Pedido pedido2 = new Pedido(Date.valueOf(LocalDate.now()), eli);
		Pedido pedido3 = new Pedido(Date.valueOf(LocalDate.now()), gabi);
		
		System.out.println(pedido1.imprimirInformacoes());
		System.out.println(pedido2.imprimirInformacoes());
		System.out.println(pedido3.imprimirInformacoes());
	}
}

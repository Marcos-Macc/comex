package br.com.comex.main;

import br.com.comex.modelo.Cliente;

public class MainCliente {
	public static void main(String[] args) {
		
		Cliente ana = new Cliente("Anna Paula", "123.123.123-89", "(56)99987-1234", "Av Batatinha", "123A", "", "bairro", "Conserva", "Pote");
		Cliente eli = new Cliente("Elisa Beatriz", "45645645689", "5555-5555", "Av Batata", "5x", " bl 1", "Camões", "Cozido", "PN");
		Cliente gabi = new Cliente("Gabriela Duarte", "789.789.789.89", "11 99999-9999", "Av Batatão", "777", "", "Lima", "Assado", "CH");
		
		System.out.println("(Sem LGPD) São as informações de "+ana.getNome()+"-> "+ana.imprimirInformacoes());
		System.out.println("(Sem LGPD) São as informações de "+eli.getNome()+"-> "+eli.imprimirInformacoes());
		System.out.println("(Sem LGPD) São as informações de "+gabi.getNome()+"-> "+gabi.imprimirInformacoes());
	}
}

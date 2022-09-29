package br.com.comex.main;

import br.com.comex.modelo.Cliente;

public class MainCliente {
	public static void main(String[] args) {
		Cliente ana = null;
		Cliente eli = null;
		Cliente gabi = null;
		try {
			ana = new Cliente("Anna Paula", "123.123.123-89", "56 9 9987-1234", "Av Batatinha", "123A", "",
					"bairro", "Conserva", "PO");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			eli = new Cliente("Elisa Beatriz", "45645645689", "(55) 5555-5555", "Av Batata", "5x", " bl 1",
					"Camões", "Cozido", "PN");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			gabi = new Cliente("Gabriela Duarte", "45645645689", "11 99999-9999", "Av Batatão", "777", "",
					"Lima", "Assado", "CH");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			Cliente teste = new Cliente("Gabriela Duarte", "45645645689", "telefone9AB", "rua123", "1", "", "B", "C",
					"PRE");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			Cliente teste1 = new Cliente("Gabriela Duarte", "CPF", "telefone", "rua", "    ", "", "bairro", "cidade",
					"estado");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		if (ana!=null) {
		System.out.println("(Sem LGPD) São as informações de " + ana.getNome() + "-> " + ana.imprimirInformacoes());
		System.out.println("(Sem LGPD) São as informações de " + ana.getNome() + "-> " + ana.toString());
		}
		System.out.println("------------------------------------------------------------------------");
		if (eli!=null) {
			System.out.println("(Sem LGPD) São as informações de " + eli.getNome() + "-> " + eli.imprimirInformacoes());
			System.out.println("(Sem LGPD) São as informações de " + eli.getNome() + "-> " + eli.toString());
		}
		System.out.println("------------------------------------------------------------------------");
		if (gabi!=null) {
			System.out.println("(Sem LGPD) São as informações de " + gabi.getNome() + "-> " + gabi.imprimirInformacoes());
			System.out.println("(Sem LGPD) São as informações de " + gabi.getNome() + "-> " + gabi.toString());
		}
		
		
	}
}

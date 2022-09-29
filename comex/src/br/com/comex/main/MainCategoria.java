package br.com.comex.main;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class MainCategoria {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
		Categoria cat3 = new Categoria("LIVROS", StatusCategoria.ATIVA);
		try {
			Categoria cat4 = new Categoria("L", StatusCategoria.ATIVA);
		}catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		System.out.println(cat1.imprimirInformacoes());
		System.out.println(cat2.imprimirInformacoes());
		System.out.println(cat3.imprimirInformacoes());
		System.out.println("------------------------");
		System.out.println(cat1.toString());
		System.out.println(cat2.toString());
		System.out.println(cat3.toString());
		 
		
	}
}

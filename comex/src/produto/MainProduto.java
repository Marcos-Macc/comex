package produto;

import categoria.Categoria;
import categoria.StatusCategoria;

public class MainProduto {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
		Categoria cat3 = new Categoria("LIVROS", StatusCategoria.ATIVA);
		Produto p1 = new Produto("Notebook Samsung", "", 3523.00, 1, cat1);
		Produto p2 = new ProdutoIsento("Clean Arquiteture", "", 102.90, 2, cat3);
		Produto p3 = new Produto("Monitor Dell 27", "", 1889.00, 3, cat1);
		try {
			Produto p4 = new Produto("Monitor Dell 27", "", 0.0, 3, cat1);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			Produto p5 = new Produto("Monitor Dell 27", "", 1889.00, 0, cat1);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			Produto p6 = new Produto("Monitor Dell 27", "", 1889.00, 3, null);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		try {
			Produto p7 = new ProdutoIsento("Clean Arquiteture", "", 0.0, 2, cat3);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
//		ProdutoIsento pi1 = new ProdutoIsento(p2);

		System.out.println(p1.imprimirInformacoes());
		System.out.println(p2.imprimirInformacoes());
		System.out.println(p3.imprimirInformacoes());
//		System.out.println(pi1.ImprimirInformacoes());
	}
}

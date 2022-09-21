package produto;

import categoria.Categoria;
import categoria.StatusCategoria;

public class MainProduto {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.Ativa);
		Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.Inativa);
		Categoria cat3 = new Categoria("LIVROS", StatusCategoria.Ativa);
		Produto p1 = new Produto("Notebook Samsung", "", 3523.00, 1, cat1);
		Produto p2 = new ProdutoIsento("Clean Arquiteture", "", 102.90, 2, cat3);
		Produto p3 = new Produto("Monitor Dell 27", "", 1889.00, 3, cat1);
//		ProdutoIsento pi1 = new ProdutoIsento(p2);
		 
		System.out.println(p1.imprimirInformacoes());
		System.out.println(p2.imprimirInformacoes());
		System.out.println(p3.imprimirInformacoes()); 
//		System.out.println(pi1.ImprimirInformacoes());
	}
}

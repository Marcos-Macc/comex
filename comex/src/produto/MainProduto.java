package produto;

import categoria.Categoria;
import categoria.StatusCategoria;

public class MainProduto {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria(1, "INFORMÁTICA", StatusCategoria.Ativa);
		Categoria cat2 = new Categoria(2, "MÓVEIS", StatusCategoria.Inativa);
		Categoria cat3 = new Categoria(3, "LIVROS", StatusCategoria.Ativa);
		Produto p1 = new Produto(1, "Notebook Samsung", "", 
				3523.00, 1, cat1);
		Produto p2 = new ProdutoIsento(2, "Clean Arquiteture", "", 
				102.90, 2, cat3);
		Produto p3 = new Produto(3, "Monitor Dell 27", "", 
				1889.00, 3, cat1);
//		ProdutoIsento pi1 = new ProdutoIsento(p2);
		 
		System.out.println(p1.ImprimirInformacoes());
		System.out.println(p2.ImprimirInformacoes());
		System.out.println(p3.ImprimirInformacoes()); 
//		System.out.println(pi1.ImprimirInformacoes());
	}
}

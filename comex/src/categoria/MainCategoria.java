package categoria;

public class MainCategoria {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.Ativa);
		Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.Inativa);
		Categoria cat3 = new Categoria("LIVROS", StatusCategoria.Ativa);
		 
		System.out.println(cat1.imprimirInformacoes());
		System.out.println(cat2.imprimirInformacoes());
		System.out.println(cat3.imprimirInformacoes());
	}
}

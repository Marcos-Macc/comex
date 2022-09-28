package categoria;

public class MainCategoria {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria cat2 = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
		Categoria cat3 = new Categoria("LIVROS", StatusCategoria.ATIVA);
		Categoria cat4 = new Categoria("L", StatusCategoria.ATIVA);
		
		System.out.println(cat1.imprimirInformacoes());
		System.out.println(cat2.imprimirInformacoes());
		System.out.println(cat3.imprimirInformacoes());
		 
		
	}
}

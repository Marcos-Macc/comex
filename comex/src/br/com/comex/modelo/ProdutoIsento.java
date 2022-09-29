package br.com.comex.modelo;

public class ProdutoIsento extends Produto {
	
	public ProdutoIsento(String nome, String descricao, double precoUnitario, int qtdeEstoque,
			Categoria categoria) {
		super(nome, descricao, precoUnitario, qtdeEstoque, categoria);
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoIsento(Produto p) {
		super(p.getNome(), p.getDescricao(),p.getPrecoUnitario(), p.getQuantidade(), p.getCategoria());
	}
 
	public double calculaValorImposto() {
		return 0.0;
	}
	
	@Override
	public String toString() {
		return imprimirInformacoes();
	}
}

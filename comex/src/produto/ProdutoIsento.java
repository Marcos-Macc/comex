package produto;

import categoria.Categoria;

public class ProdutoIsento extends Produto {
	
	public ProdutoIsento(int id, String nome, String descricao, double precoUnitario, int qtdeEstoque,
			Categoria categoria) {
		super(id, nome, descricao, precoUnitario, qtdeEstoque, categoria);
		// TODO Auto-generated constructor stub
	}
	
	public ProdutoIsento(Produto p) {
		super(p.getId(), p.getNome(), p.getDescricao(),p.getPrecoUnitario(), p.getQtdeEstoque(), p.getCategoria());
	}
 
	public double calculaValorImposto() {
		return 00;
	}
}

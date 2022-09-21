package produto;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double precoUnitario;
	private int qtdeEstoque;
	private categoria.Categoria categoria;
	private static int totalProduto = 0;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}
	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	public categoria.Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(categoria.Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Produto(String nome,
	String descricao,
	double precoUnitario,
	int qtdeEstoque,
	categoria.Categoria categoria) {
		++totalProduto;
		this.id = totalProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.qtdeEstoque = qtdeEstoque;
		this.categoria = categoria;
	}
	
	public double calculaValorTotalEstoque() {
		return this.qtdeEstoque*this.precoUnitario;
	}
	
	public double calculaValorImposto() {
		return 0.4*this.precoUnitario;
	}
	
	public String imprimirInformacoes() {
		return "O produto: "+this.nome.trim()+", da categoria "+this.categoria.getNome()+
				", custa R$"+String.format("%.2f",this.precoUnitario)+" por unidade. Há ainda "+this.qtdeEstoque+" na loja."+
				" Seu valor total em estoque é de R$"+String.format("%.2f",this.calculaValorTotalEstoque())+" e seu imposto é de R$"+String.format("%.2f",this.calculaValorImposto())+".";
	}
}

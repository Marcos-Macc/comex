package br.com.comex.modelo;

public class Produto implements IValoresProduto {
	private int id;
	private String nome;
	private String descricao;
	private double precoUnitario = 0.0;
	private int quantidade;
	private br.com.comex.modelo.Categoria categoria;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public br.com.comex.modelo.Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(br.com.comex.modelo.Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Produto(String nome,
	String descricao,
	double precoUnitario,
	int quantidade,
	br.com.comex.modelo.Categoria categoria) {
		++totalProduto;
		if (totalProduto<0) {
			throw new IllegalArgumentException("ID deve ser maior que 0.");
		}
		if ((nome==null)) {
			throw new IllegalArgumentException("Nome é obrigatório!");
		}
		if ((nome.trim().length()<=5)) {
			throw new IllegalArgumentException("Nome deve ter mais de 5 caracteres.");
		}
		if (precoUnitario<=0) {
			throw new IllegalArgumentException("Preço Unitário é obrigatório e deve ser maior que 0.");
		}
		if (quantidade<=0) {
			throw new IllegalArgumentException("Quantidade é obrigatória e deve ser maior que 0.");
		}
		if (categoria==null) {
			throw new IllegalArgumentException("Categoria é obrigatória.");
		}
		this.id = totalProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.categoria = categoria;
		
	}
	
	public double calculaValorTotalEstoque() {
		return this.quantidade*this.precoUnitario;
	}
	
	public double calculaValorImposto() {
		return 0.4*this.precoUnitario;
	}
	
	public String imprimirInformacoes() {
		return "O produto: "+this.nome.trim()+", da categoria "+this.categoria.getNome()+
				", custa R$"+String.format("%,.2f",this.precoUnitario)+" por unidade. Há ainda "+this.quantidade+" na loja."+
				" Seu valor total em estoque é de R$"+String.format("%,.2f",this.calculaValorTotalEstoque())+" e seu imposto é de R$"+String.format("%,.2f",this.calculaValorImposto())+".";
	}
	@Override
	public double getValorTotal() {
		return calculaValorTotalEstoque();
	}
}
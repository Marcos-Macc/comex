package br.com.comex.modelo;

public class ItemPedido implements IValoresProduto {
	private int id;
	private double precoUnitario;
	private int quantidade;
	private Produto produto;
	private Pedido pedido;
	private double desconto;
	private tipoDescontoPedido tipoDesconto;
	private static int totalItemPedido = 0;

	public int getId() {
		return id;
	}
	
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public void setTipoDesconto(tipoDescontoPedido tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public double getDesconto() {
		return desconto;
	}

	public tipoDescontoPedido getTipoDesconto() {
		return tipoDesconto;
	}

	public ItemPedido(int quantidade, Produto produto, Pedido pedido, double desconto,
			tipoDescontoPedido tipoDesconto) {
		++totalItemPedido;
		this.id = totalItemPedido;
		this.precoUnitario = produto.getPrecoUnitario();
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
		if (desconto > 100.0)
			this.desconto = desconto;
		else if (desconto < 0.0)
			this.desconto = 0.0;
		else
			this.desconto = desconto;
		if (tipoDesconto == null)
			this.tipoDesconto = tipoDescontoPedido.NENHUM;
		else
			this.tipoDesconto = tipoDesconto;
	}
	
	public ItemPedido(int id, int quantidade, Produto produto, Pedido pedido, double desconto,
			tipoDescontoPedido tipoDesconto) {
		this.id = id;
		this.precoUnitario = produto.getPrecoUnitario();
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
		if (desconto > 100.0)
			this.desconto = desconto;
		else if (desconto < 0.0)
			this.desconto = 0.0;
		else
			this.desconto = desconto;
		if (tipoDesconto == null)
			this.tipoDesconto = tipoDescontoPedido.NENHUM;
		else
			this.tipoDesconto = tipoDesconto;
	}

	private double precoTotalSemDesconto() {
		return this.precoUnitario * this.quantidade;
	}

	public double calculaDesconto() {
		double desconto = 0.0;
		if (this.tipoDesconto == tipoDescontoPedido.PROMOCAO)
			desconto = 0.20;
		else if (this.tipoDesconto == tipoDescontoPedido.QUANTIDADE)
			if (this.quantidade > 10)
				desconto = 0.10;
		return desconto;
	}
	
	public double precoTotalComDesconto() {
		return this.precoTotalSemDesconto()*(1-this.calculaDesconto());
	}
	
	public String imprimirInformacoes() {
		return "-----\n"+"Cliente: "+this.getPedido().getCliente().getNome()+"\n"+
				"Produto: "+this.getProduto().getNome()+"\n"+
				"Quantidade: "+this.quantidade+"\t Valor Unid.: "+String.format("%,.2f",this.precoUnitario)+
				"\t Valor Total Sem Desconto: "+String.format("%,.2f",this.precoTotalSemDesconto())+
				"\t Desconto: "+this.calculaDesconto()*100+"%"+
				"\t Valor Total Com Desconto: "+String.format("%,.2f",this.precoTotalComDesconto());
	}

	@Override
	public double getValorTotal() {
		return precoTotalSemDesconto();
	}
	
	@Override
	public String toString() {
		return imprimirInformacoes();
	}

}

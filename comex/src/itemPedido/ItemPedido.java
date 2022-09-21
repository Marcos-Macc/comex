package itemPedido;

import produto.Produto;
import pedido.Pedido;

public class ItemPedido {
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

	private double precoTotalSemDesconto() {
		return this.precoUnitario * this.quantidade;
	}

	public double calculaDesconto() {
		double desconto = 0.0;
		if (this.tipoDesconto == tipoDescontoPedido.NENHUM)
			desconto = 0.0;
		else if (this.tipoDesconto == tipoDescontoPedido.PROMOÇÃO)
			desconto = 0.20;
		else if (this.tipoDesconto == tipoDescontoPedido.QUANTIDADE)
			if (this.quantidade > 10)
				desconto = 0.10;
			else
				desconto = 0.0;
		return desconto;
	}
	
	public double precoTotalComDesconto() {
		return this.precoTotalSemDesconto()*(1-this.calculaDesconto());
	}
	
	public String imprimirInformacoes() {
		return "-----\n"+"Cliente: "+this.getPedido().getCliente().getNome()+"\n"+
				"Produto: "+this.getProduto().getNome()+"\n"+
				"Quantidade: "+this.quantidade+"\t Valor Unid.: "+String.format("%.2f",this.precoUnitario)+
				"\t Valor Total Sem Desconto: "+String.format("%.2f",this.precoTotalSemDesconto())+
				"\t Desconto: "+this.calculaDesconto()*100+"%"+
				"\t Valor Total Com Desconto: "+String.format("%.2f",this.precoTotalComDesconto());
	}

	/*
	 * Cria uma classe `ItemPedido` com o seguinte conteúdo:
	 * 
	 * 
	 * - **id**: númerico, chave primária, auto incrementado - **preço unitário:**
	 * preço do produto na data da compra; - **quantidade:** quantidade comprada no
	 * pedido; - **produto:** produto que foi comprado; - **pedido:** pedido do qual
	 * este item faz parte; - **desconto:** bônus concedido, - **tipo de desconto:**
	 * QUANTIDADE, PROMOCAO ou NENHUM.
	 * 
	 * Defina os _getters_ para todos os atributos.
	 * 
	 * Não defina _setters_. Receba os dados pelo construtor.
	 * 
	 * Defina também métodos que realizam as seguintes operações:
	 * 
	 * - **preco total sem descontos**: é o preço unitário do item do pedido
	 * multiplicado pela quantidade 
	 * - **calcula desconto**: 0 quando for nenhum, 20%
	 * quando for promoção e 10% se a quantidade ultrapassar de 10 
	 * - **preco total
	 * com descontos**: subtrai o preço total dos descontos
	 * 
	 * Crie uma classe `MainItemPedido` e crie alguns pedidos e itens do pedido!
	 * Defina outros objetos conforme for necessário.
	 * 
	 * Imprima as informações em um layout bacana!
	 */
}

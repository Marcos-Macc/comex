package calculadoraValorTotal;

import valoresProduto.IValoresProduto;

public class CalculadoraValorTotal {
	
	private double valorTotal;
	
	public String imprimirInformacoes() {
		return "Valor Total: "+String.format("%.2f",this.valorTotal);
	}
	
	public String calcula(IValoresProduto vp) {
		this.valorTotal = vp.getValorTotal();
		return imprimirInformacoes();
	}
	public String classe(IValoresProduto vp) {
		return vp.getClass().toString();
	}
	
	
	
/*
 Tanto `Produto` como `ItemPedido` possuem atributos para o preço unitário e quantidade.

Defina uma classe `CalculadoraValorTotal` com um método `calcula` que pode receber, 
no mesmo métodos, tanto um `Produto` como um `ItemPedido` e retorna o resultad do seguinte 
cálculo:

- total = preço unitário x quantidade

Crie uma classe `MainCalculadoraValorTotal`, definindo alguns produtos e itens do pedido e faça com que sejam impressos os valores totais!
 */
}

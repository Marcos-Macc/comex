package calculadoraValorTotal;

import valoresProduto.IValoresProduto;

public class CalculadoraValorTotal {
	
	private double valorTotal;
	
	public String imprimirInformacoes() {
		return "Valor Total: "+String.format("%,.2f",this.valorTotal);
	}
	
	public String calcula(IValoresProduto vp) {
		this.valorTotal = vp.getValorTotal();
		return imprimirInformacoes();
	}
	public String classe(IValoresProduto vp) {
		return vp.getClass().toString();
	}
	
}

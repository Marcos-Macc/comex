package br.com.comex.modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Pedido {
	private Long id;
	private Date data;
	private Cliente cliente;
	private static int totalPedido = 0;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setData(Date data) {
		this.data = data;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido(Date data, Cliente cliente) {
		++totalPedido;
		this.id = (long) totalPedido;
		this.data = data;
		this.cliente = cliente;
	}
	
	public Pedido(Long id, Date data, Cliente cliente) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
	}

	public String imprimirInformacoes() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return "Pedido nº: "+this.id+" feito dia "+f.format(this.data)+" por "+this.cliente.getNome()+".";
	}
	
	@Override
	public String toString() {
		return imprimirInformacoes();
	}
	
}

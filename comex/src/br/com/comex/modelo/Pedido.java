package br.com.comex.modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Pedido {
	private int id;
	private Date data;
	private Cliente cliente;
	private static int totalPedido = 0;

	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Pedido(Date data, Cliente cliente) {
		++totalPedido;
		this.id = totalPedido;
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

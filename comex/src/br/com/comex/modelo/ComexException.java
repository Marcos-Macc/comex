package br.com.comex.modelo;

public class ComexException extends RuntimeException {
	public ComexException() {
		super();
	}
	
	public ComexException(String msg) {
		super(msg);
	}
}

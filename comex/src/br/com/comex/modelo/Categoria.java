package br.com.comex.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Categoria {
	private Long id;
	
	@XmlElement(required = true)
	private String nome;
	
	private StatusCategoria status = StatusCategoria.ATIVA;
	private static int totalCategoria = 0;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.trim();
	}
	public StatusCategoria getStatus() {
		return status;
	}
	public void setStatus(StatusCategoria status) {
		this.status = status;
	}
	
	public Categoria() {
		
	}
	
	public Categoria(String nome, StatusCategoria status) {
		++totalCategoria;
		if (totalCategoria < 1 ) {
			throw new IllegalArgumentException("ID inválido. Deve ser Maior que 0.");
		}
		if (nome == null) {
			throw new IllegalArgumentException("Nome da Categoria é obrigatório.");
		}
		if (nome.trim().length() <= 3 ) {
			throw new IllegalArgumentException("Nome inválido. Deve ter mais que 3 caracteres.");
		}
		if (Character.isDigit(nome.charAt(0)) ) {
			throw new IllegalArgumentException("Nome: "+nome+" não pode começar com um número.");
		}
		if (status==null ) {
			throw new IllegalArgumentException("Status inválido. Deve ser StatusCategoria.ATIVA ou StatusCategoria.INATIVA.");
		}
		this.id = (long) totalCategoria;
		this.nome = nome;
		this.status = status;
	}
	
	public Categoria(Long id, String nome, StatusCategoria status) {

		if (id < 1 ) {
			throw new IllegalArgumentException("ID inválido. Deve ser Maior que 0.");
		}
		if (nome == null) {
			throw new IllegalArgumentException("Nome da Categoria é obrigatório.");
		}
		if (nome.trim().length() <= 3 ) {
			throw new IllegalArgumentException("Nome inválido. Deve ter mais que 3 caracteres.");
		}
		if (Character.isDigit(nome.charAt(0)) ) {
			throw new IllegalArgumentException("Nome: "+nome+" não pode começar com um número.");
		}
		if (status==null ) {
			throw new IllegalArgumentException("Status inválido. Deve ser StatusCategoria.ATIVA ou StatusCategoria.INATIVA.");
		}
		this.id = id;
		this.nome = nome;
		this.status = status;
	}
	
	public String imprimirInformacoes() {
		return "Categoria " + this.nome.trim() + " (" + this.id +
				" - " + this.status+ ")";
	}
	
	@Override
	public String toString() {
		return imprimirInformacoes();
	}

}

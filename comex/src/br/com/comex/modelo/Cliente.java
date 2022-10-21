package br.com.comex.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Cliente {
	private Long id;
	@XmlElement(required = true)
	private String nome;
	@XmlElement(required = true)
	private String cpf;
	@XmlElement(required = true)
	private String telefone;
	@XmlElement(required = true)
	private String rua;
	@XmlElement(required = true)
	private String numero;
	private String complemento;
	@XmlElement(required = true)
	private String bairro;
	@XmlElement(required = true)
	private String cidade;
	@XmlElement(required = true)
	private siglaEstado estado;
	private static int totalCliente = 0;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getRua() {
		return rua;
	}
	public String getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public siglaEstado getEstado() {
		return estado;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(siglaEstado estado) {
		this.estado = estado;
	}
	
	public Cliente() {
		
	}
	
	public Cliente(String nome,
	String cpf,
	String telefone,
	String rua,
	String numero,
	String complemento,
	String bairro,	
	String cidade,
	siglaEstado estado) {
		++totalCliente;
		if (totalCliente<0) {
			throw new ComexException("ID do Cliente deve ser maior que 0.");
		}
		if (nome==null) {
			throw new ComexException("Nome do Cliente é obrigatório.");
		}
		if (nome.trim().length()<6) {
			throw new ComexException("Nome do Cliente deve conter mais de 5 caracteres.");
		}
		if (Character.isDigit(nome.charAt(0)) ) {
			throw new ComexException("Nome: "+nome+" não pode começar com um número.");
		}
		if (cpf == null || (cpf.trim().length()<11 || cpf.trim().length() >14)) {
			throw new ComexException("CPF do Cliente é obrigatório e deve conter entre 11 a 14 caracteres.");
		}
		if(!cpf.substring(0, 3).matches("[0-9]*")||!(cpf.substring(3,4).equals("."))||
				!cpf.substring(4, 7).matches("[0-9]*")||!(cpf.substring(7,8).equals("."))||
				!cpf.substring(8, 11).matches("[0-9]*")||!(cpf.substring(11,12).equals("-"))||
				!cpf.substring(12, 14).matches("[0-9]*")){
			throw new ComexException("CPF deve ser escrito em formato 'xxx.xxx.xxx-xx'.");
		}
		if (telefone != null && telefone.trim().length()<11 || telefone.trim().length()>16) {
			throw new ComexException("Telefone do Cliente é obrigatório e deve conter entre 11 a 16 caracteres.");
		}
		if(telefone != null && !telefone.matches("^\\([0-9]{2}\\) [0-9]{1} ([0-9]{4}-[0-9]{4})$")) {
			throw new ComexException(telefone.trim() +"Telefone deve ser escrito no formato '(xx) x xxxx-xxxx'.");
		}
			
		if (rua==null || rua.trim().length()<6) {
			throw new ComexException("Rua é campo obrigatório e deve conter mais de 5 caracteres.");
		}
		if (numero==null || numero.trim().length()<1) {
			throw new ComexException("Número é campo obrigatório e deve conter mais de 5 caracteres.");
		}
		if (bairro==null || bairro.trim().length()<1) {
			throw new ComexException("Bairro é campo obrigatório e deve conter mais de 1 caracter.");
		}
		if (cidade==null || cidade.trim().length()<1) {
			throw new ComexException("Cidade é campo obrigatório e deve conter mais de 1 caracter.");
		}
		if (estado==null) {
			//throw new IllegalArgumentException("Estado é campo obrigatório e deve conter exatamente 2 caracteres.");
			throw new ComexException("Estado é campo obrigatório e deve conter exatamente 2 caracteres.");
		}	
		
		this.id = (long) totalCliente;
		this.nome = nome.trim();
		this.cpf = cpf.trim();
		this.telefone = telefone.trim();
		this.rua = rua.trim();
		this.numero = numero.trim();
		this.complemento = complemento;
		this.bairro = bairro.trim();
		this.cidade = cidade.trim();
		this.estado = estado;
	}
	
	public Cliente(Long id, String nome,
			String cpf,
			String telefone,
			String rua,
			String numero,
			String complemento,
			String bairro,	
			String cidade,
			siglaEstado uf) {
				if (id<=0) {
					throw new ComexException("ID do Cliente deve ser maior que 0.");
				}
				if (nome==null) {
					throw new ComexException("Nome do Cliente é obrigatório.");
				}
				if (nome.trim().length()<6) {
					throw new ComexException("Nome do Cliente deve conter mais de 5 caracteres.");
				}
				if (Character.isDigit(nome.charAt(0)) ) {
					throw new ComexException("Nome: "+nome+" não pode começar com um número.");
				}
				if (cpf == null || (cpf.trim().length()<11 || cpf.trim().length() >14)) {
					throw new ComexException("CPF do Cliente é obrigatório e deve conter entre 11 a 14 caracteres.");
				}
				if(!cpf.substring(0, 3).matches("[0-9]*")||!(cpf.substring(3,4).equals("."))||
						!cpf.substring(4, 7).matches("[0-9]*")||!(cpf.substring(7,8).equals("."))||
						!cpf.substring(8, 11).matches("[0-9]*")||!(cpf.substring(11,12).equals("-"))||
						!cpf.substring(12, 14).matches("[0-9]*")){
					throw new ComexException("CPF deve ser escrito em formato 'xxx.xxx.xxx-xx'.");
				}
				if (telefone != null && telefone.trim().length()<11 || telefone.trim().length()>16) {
					throw new ComexException("Telefone do Cliente é obrigatório e deve conter entre 11 a 16 caracteres.");
				}
				if(telefone != null && !telefone.matches("^\\([0-9]{2}\\) [0-9]{1} ([0-9]{4}-[0-9]{4})$")) {
					throw new ComexException(telefone.trim() +"Telefone deve ser escrito no formato '(xx) x xxxx-xxxx'.");
				}
					
				if (rua==null || rua.trim().length()<6) {
					throw new ComexException("Rua é campo obrigatório e deve conter mais de 5 caracteres.");
				}
				if (numero==null || numero.trim().length()<1) {
					throw new ComexException("Número é campo obrigatório e deve conter mais de 5 caracteres.");
				}
				if (bairro==null || bairro.trim().length()<1) {
					throw new ComexException("Bairro é campo obrigatório e deve conter mais de 1 caracter.");
				}
				if (cidade==null || cidade.trim().length()<1) {
					throw new ComexException("Cidade é campo obrigatório e deve conter mais de 1 caracter.");
				}
				if (uf==null) {
					//throw new IllegalArgumentException("Estado é campo obrigatório e deve conter exatamente 2 caracteres.");
					throw new ComexException("Estado é campo obrigatório e deve conter exatamente 2 caracteres.");
				}	
				
				this.id = id;
				this.nome = nome.trim();
				this.cpf = cpf.trim();
				this.telefone = telefone.trim();
				this.rua = rua.trim();
				this.numero = numero.trim();
				this.complemento = complemento;
				this.bairro = bairro.trim();
				this.cidade = cidade.trim();
				this.estado = uf;
			}
	
	
	public String imprimirInformacoes() {
		return "nome: "+this.nome+", cpf: "+this.cpf+", telefone: "+this.telefone+""+
				", endereço: "+this.rua+", "+this.numero+" "+this.complemento+" - "+this.bairro+
				", "+this.cidade+"/"+this.estado;
	}
	
	@Override
	public String toString() {
		return imprimirInformacoes();
	}
	

}

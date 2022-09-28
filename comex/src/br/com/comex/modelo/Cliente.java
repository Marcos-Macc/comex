package br.com.comex.modelo;

public class Cliente {
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private static int totalCliente = 0;
	
	public int getId() {
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
	public String getEstado() {
		return estado;
	}
	
	public Cliente(String nome,
	String cpf,
	String telefone,
	String rua,
	String numero,
	String complemento,
	String bairro,	
	String cidade,
	String estado) {
		++totalCliente;
		if (totalCliente<0) {
			throw new IllegalArgumentException("ID do Cliente deve ser maior que 0.");
		}
		if (nome==null) {
			throw new IllegalArgumentException("Nome do Cliente é obrigatório.");
		}
		if (nome.trim().length()<6) {
			throw new IllegalArgumentException("Nome do Cliente deve conter mais de 5 caracteres.");
		}
		if (cpf == null || (cpf.trim().length()<11 || cpf.trim().length() >14)) {
			throw new IllegalArgumentException("CPF do Cliente é obrigatório e deve conter entre 11 a 14 caracteres.");
		}
		if (telefone != null && telefone.trim().length()<11 || telefone.trim().length()>16) {
			throw new IllegalArgumentException("Telefone do Cliente é obrigatório e deve conter entre 11 a 16 caracteres.");
		}
		if (rua==null || rua.trim().length()<6) {
			throw new IllegalArgumentException("Rua é campo obrigatório e deve conter mais de 5 caracteres.");
		}
		if (numero==null || numero.trim().length()<1) {
			throw new IllegalArgumentException("Número é campo obrigatório e deve conter mais de 5 caracteres.");
		}
		if (bairro==null || bairro.trim().length()<1) {
			throw new IllegalArgumentException("Bairro é campo obrigatório e deve conter mais de 1 caracter.");
		}
		if (cidade==null || cidade.trim().length()<1) {
			throw new IllegalArgumentException("Cidade é campo obrigatório e deve conter mais de 1 caracter.");
		}
		if (estado==null||estado.trim().length()!=2) {
			throw new IllegalArgumentException("Estado é campo obrigatório e deve conter exatamente 2 caracteres.");
		}	
		
		this.id = totalCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String imprimirInformacoes() {
		return "nome: "+this.nome+", cpf: "+this.cpf+", telefone: "+this.telefone+""+
				", endereço: "+this.rua+", "+this.numero+" "+this.complemento+" - "+this.bairro+
				", "+this.cidade+"/"+this.estado;
	}

}

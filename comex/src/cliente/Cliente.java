package cliente;

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

package categoria;

public class Categoria {
	private int id;
	private String nome;
	private StatusCategoria status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	public Categoria(int id, String nome, StatusCategoria status) {
		this.id = id;
		this.nome = nome;
		this.status = status;
	}
	
	public String imprimirInformacoes() {
		return "Categoria " + this.nome.trim() + " (" + this.id +
				" - " + this.status+ ")";
	}

}

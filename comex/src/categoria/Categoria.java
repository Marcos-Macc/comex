package categoria;

public class Categoria {
	private int id;
	private String nome;
	private StatusCategoria status;
	private static int totalCategoria = 0;
	 
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
	
	public Categoria(String nome, StatusCategoria status) {
		++totalCategoria;
		this.id = totalCategoria;
		this.nome = nome;
		this.status = status;
	}
	
	public String imprimirInformacoes() {
		return "Categoria " + this.nome.trim() + " (" + this.id +
				" - " + this.status+ ")";
	}

}

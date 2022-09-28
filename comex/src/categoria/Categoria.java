package categoria;

public class Categoria {
	private int id;
	private String nome;
	private StatusCategoria status = StatusCategoria.ATIVA;
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
		if (totalCategoria < 1 ) {
			throw new IllegalArgumentException("ID inválido. Deve ser Maior que 0.");
		}
		if (nome == null) {
			throw new IllegalArgumentException("Nome da Categoria é obrigatório.");
		}
		if (nome.length() <= 3 ) {
			throw new IllegalArgumentException("Nome inválido. Deve ter mais que 3 caracteres.");
		}
		if (status != StatusCategoria.ATIVA && status != StatusCategoria.INATIVA ) {
			throw new IllegalArgumentException("Status inválido. Deve ser StatusCategoria.ATIVA ou StatusCategoria.INATIVA.");
		}
		this.id = totalCategoria;
		this.nome = nome;
		this.status = status;
	}
	
	public String imprimirInformacoes() {
		return "Categoria " + this.nome.trim() + " (" + this.id +
				" - " + this.status+ ")";
	}

}

package br.com.comex.modelo;

public enum StatusCategoria {
	ATIVA("ATIVA"), INATIVA("INATIVA");
	

    private String descricao;

    StatusCategoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

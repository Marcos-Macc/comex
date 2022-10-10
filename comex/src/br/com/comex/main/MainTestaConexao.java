package br.com.comex.main;

import java.sql.SQLException;

import br.com.comex.modelo.ConnectionFactory;

public class MainTestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory c = new ConnectionFactory();
		
		if (c!=null) {
			System.out.println("Conexão efetuada com sucesso.");
			c.fechaConexao();
		}

	}

}

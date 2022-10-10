package br.com.comex.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.modelo.ConnectionFactory;

public class MainTestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory coF = new ConnectionFactory();
		Connection c = coF.abreConexao();
		
		if (c!=null) {
			System.out.println("Conexão efetuada com sucesso.");
			coF.fechaConexao(c);
		}

	}

}

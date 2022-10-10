package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.modelo.ConnectionFactory;

public class MainAtualizacaoCategoria {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		PreparedStatement psmt = c.prepareStatement("UPDATE comex.categoria SET"
				+ " nome = 'LIVROS TÉCNICOS' where nome = 'LIVROS'");
		psmt.execute();

	}
}

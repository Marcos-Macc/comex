package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.modelo.ConnectionFactory;

public class MainInsercaoCategoria {
	
	public static void adicionaCategoria(String nome, String status, PreparedStatement psmt) throws SQLException {
		psmt.setString(1, nome);
		psmt.setString(2, status);
		psmt.execute();
	}

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		String sql = "INSERT into comex.categoria(NOME,STATUS) VALUES(?,?)";
		PreparedStatement stm = c.prepareStatement(sql);
		adicionaCategoria("INFORMÁTICA","ATIVA",stm);
		adicionaCategoria("MÓVEIS","INATIVA",stm);
		adicionaCategoria("LIVROS","ATIVA",stm);

		conF.fechaConexao(c);

	}
	
}

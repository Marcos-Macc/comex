package br.com.comex.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.modelo.ConnectionFactory;

public class MainInsercaoCategoria {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		String sql = "BEGIN INSERT into comex.categoria(NOME,STATUS) VALUES('INFORMÁTICA','ATIVA');"
				+ "INSERT into comex.categoria(NOME,STATUS) VALUES('MÓVEIS','INATIVA');"
				+ "INSERT into comex.categoria(NOME,STATUS) VALUES('LIVROS','ATIVA');COMMIT;END;";
		Statement stm = c.createStatement();
		int iGravados = stm.executeUpdate(sql);
		System.out.println(iGravados);
		conF.fechaConexao(c);

	}
	
}

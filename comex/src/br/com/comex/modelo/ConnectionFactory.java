package br.com.comex.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection abreConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "SYSTEM", "admin");
	}

	public void fechaConexao(Connection con) throws SQLException {
		con.close();
	}
}

package br.com.comex.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	Connection con = null;
	public ConnectionFactory() throws SQLException {
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe"			, "SYSTEM", "admin");
	}
	
	public Connection getCon() {
		return con;
	}

	public void fechaConexao() throws SQLException {
		con.close();
	}
}

package br.com.comex.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1522:xe");
		comboPooledDataSource.setUser("SYSTEM");
		comboPooledDataSource.setPassword("admin");
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection abreConexao() {
		try {
		  return this.dataSource.getConnection();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "SYSTEM", "admin");
	}

	public void fechaConexao(Connection con) {
		try {
			con.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
	}
	}
}

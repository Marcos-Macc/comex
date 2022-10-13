package br.com.comex.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.comex.modelo.ConnectionFactory;

public class MainRemocaoCategoria {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		PreparedStatement pstm = c.prepareStatement("DELETE FROM comex.categoria "
				+ "WHERE upper(STATUS) = 'INATIVA'");
		
		pstm.execute();

	}

}

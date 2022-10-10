package br.com.comex.main;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.StatusCategoria;

public class MainListagemCategoria {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		Statement smt = c.createStatement();
		ResultSet rs = smt.executeQuery("select * from comex.categoria order by id");
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		while(rs.next()) {
			Categoria cat = new Categoria();
			cat.setId(rs.getInt("id"));
			cat.setNome(rs.getString("nome").trim());
			if(rs.getString("status").equals("ATIVA")) {
				cat.setStatus(StatusCategoria.ATIVA);
			}else {
				cat.setStatus(StatusCategoria.INATIVA);
			}; 
			categorias.add(cat);
		}
		conF.fechaConexao(c);
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getId()+"-"+categoria.getNome()+" - "+categoria.getStatus());
		}
	}
}

package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.CategoriasDAO;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.StatusCategoria;

public class MainTestaCategoriasDAO {

	public static void main(String[] args) {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		CategoriasDAO catDAO = new CategoriasDAO(c);
		
		Categoria cat1 = new Categoria("teste3",StatusCategoria.ATIVA);
		catDAO.insereCategoria(cat1);
		List<Categoria> lcat = catDAO.listaTodos();
		for (Categoria c1 : lcat) {
			System.out.println(c1.toString());
		}
		cat1.setNome("teste26");
		catDAO.atualizaCategoria(cat1);
		catDAO.deletaCategoriasInativas();
		catDAO.deletaCategoria(cat1);
		conF.fechaConexao(c);
			

	}

}

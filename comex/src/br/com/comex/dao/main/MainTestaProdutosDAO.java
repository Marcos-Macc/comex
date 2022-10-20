package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.CategoriasDAO;
import br.com.comex.dao.ProdutosDAO;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.ProdutoIsento;
import br.com.comex.modelo.StatusCategoria;

public class MainTestaProdutosDAO {

	public static void main(String[] args) {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		ProdutosDAO pDAO = new ProdutosDAO(c);

		List<Categoria> cat = new CategoriasDAO(c).listaTodos();

		Produto p1 = new Produto("Notebook Samsung", "", 3523.00, 1, cat.get(0), "NAO_ISENTO");
		Produto p2 = new ProdutoIsento("Clean Arquiteture", "", 102.90, 2, cat.get(1), "ISENTO");
		Produto p3 = new Produto("Monitor Dell 27", "", 1889.00, 3, cat.get(1), "NAO_ISENTO");

		pDAO.insereProduto(p1);
		pDAO.insereProduto(p2);
		pDAO.insereProduto(p3);

		List<Produto> lcat = pDAO.listaTodos();
		for (Produto c1 : lcat) {
			System.out.println(c1.toString());
		}
		p1.setNome("teste99");
		pDAO.atualizaProduto(p1);
		pDAO.deletaProduto(p1);
		conF.fechaConexao(c);

	}

}
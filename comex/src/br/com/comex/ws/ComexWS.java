package br.com.comex.ws;

import java.sql.Connection;
import java.util.List;

import javax.jws.WebService;

import br.com.comex.dao.CategoriasDAO;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ConnectionFactory;

@WebService
public class ComexWS {
	public List<Categoria> getCategorias() {
		ConnectionFactory conf = new ConnectionFactory();
		Connection c = conf.abreConexao();
		CategoriasDAO cDAO = new CategoriasDAO(c);
		return cDAO.listaCategoria(0);
	}
}

package br.com.comex.ws;

import java.sql.Connection;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.comex.dao.CategoriasDAO;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.StatusCategoria;

@WebService
public class ComexWS {
	
	@WebMethod(operationName = "listarCategorias")
	public List<Categoria> getCategorias() {
		ConnectionFactory conf = new ConnectionFactory();
		Connection c = conf.abreConexao();
		CategoriasDAO cDAO = new CategoriasDAO(c);
		return cDAO.listaCategoria(0);
	}
	
	public int adicionarCategoria() {
		ConnectionFactory conf = new ConnectionFactory();
		Connection c = conf.abreConexao();
		CategoriasDAO cDAO = new CategoriasDAO(c);
		Categoria cat = new Categoria("TESTANDO SOAP", StatusCategoria.ATIVA);
		return cDAO.insereCategoria(cat);
	}
}

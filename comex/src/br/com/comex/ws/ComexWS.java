package br.com.comex.ws;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;

import br.com.comex.dao.CategoriasDAO;
import br.com.comex.dao.ClientesDAO;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.StatusCategoria;

@WebService
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.WRAPPED, use = Use.LITERAL)
public class ComexWS {
	
	@WebMethod(operationName = "listarCategorias")
	public List<Categoria> getCategorias() {
		List<Categoria> cat = new ArrayList<Categoria>();
		ConnectionFactory conf = new ConnectionFactory();
		Connection c = conf.abreConexao();
		CategoriasDAO cDAO = new CategoriasDAO(c);
		cat = cDAO.listaTodos();
		conf.fechaConexao(c);
		return cat;
	}
	
	public Long adicionarCategoria(@WebParam(name="categoria") @XmlElement(required = true) String categoria) {
		Long id = new Long(0);
		ConnectionFactory conf = new ConnectionFactory();
		Connection c = conf.abreConexao();
		CategoriasDAO cDAO = new CategoriasDAO(c);
		Categoria cat = new Categoria(categoria, StatusCategoria.ATIVA);
		cDAO.insereCategoria(cat);
		id = cat.getId();
		conf.fechaConexao(c);
		return id;
	}
	
	@WebResult(name = "Cliente")
	public List<Cliente> listarClientes(){
		List<Cliente> cli = new ArrayList<Cliente>();
		ConnectionFactory conf = new ConnectionFactory();
		Connection c = conf.abreConexao();
		ClientesDAO cliDAO = new ClientesDAO(c);
		cli = cliDAO.listaTodos();
		conf.fechaConexao(c);
		return cli;
	}
}

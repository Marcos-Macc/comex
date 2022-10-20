package br.com.comex.dao.main;

import java.sql.Connection;
import java.util.List;

import br.com.comex.dao.ClientesDAO;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ConnectionFactory;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.siglaEstado;

public class MainTestaClientesDAO {

	public static void main(String[] args) {
		ConnectionFactory conF = new ConnectionFactory();
		Connection c = conF.abreConexao();
		ClientesDAO cDAO = new ClientesDAO(c);
		Cliente ana = new Cliente("Anna Paula", "123.123.123-89", "(56) 9 9987-1234", "Av Batatinha", "123A", "",
				"bairro", "Conserva", siglaEstado.PR);
		Cliente eli = new Cliente("Elisa Beatriz", "123.123.123-80", "(55) 5 5555-5555", "Av Batata", "5x", " bl 1",
				"Camões", "Cozido", siglaEstado.PR);
		Cliente gabi = new Cliente("Gabriela Duarte", "123.123.123-81", "(11) 9 9999-9999", "Av Batatão", "777", "",
				"Lima", "Assado", siglaEstado.PR);
		
		cDAO.insereCliente(ana);
		cDAO.insereCliente(eli);
		cDAO.insereCliente(gabi);
		
		List<Cliente> lcat = cDAO.listaTodos();
		for (Cliente c1 : lcat) {
			System.out.println(c1.toString());
		}
		ana.setNome("teste99");
		cDAO.atualizaCliente(ana);
		cDAO.deletaCliente(ana);
		
		conF.fechaConexao(c);
		

	}

}
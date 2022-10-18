package br.com.comex.main;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import br.com.comex.modelo.Categoria;
import br.com.comex.ws.ComexWS;

public class MainComexWS {

	public static void main(String[] args) {

		ComexWS service = new ComexWS();
//		List<Categoria> c = new ArrayList<Categoria>();
//		c = service.getCategorias();
//		for (Categoria cat : c) {
//			System.out.println(cat.toString());
//		}
		String url = "http://localhost:8080/ComexWS";
		
		Endpoint.publish(url, service);

	}

}

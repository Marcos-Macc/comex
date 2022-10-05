package br.com.comex.csv;

//import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorPedidosCsv {
	
	public List<PedidoCsv> leituraPedidosCsv() throws IOException{
		InputStream is = new FileInputStream("pedidos.csv");
		Scanner scanner = new Scanner(is);
		List<PedidoCsv> ll = new ArrayList<PedidoCsv>();
		scanner.nextLine();
		while(scanner.hasNext()) {
			String valores[] = scanner.nextLine().split(",");
			PedidoCsv p = new PedidoCsv(valores[0], valores[1], valores[5], valores[2], valores[3], valores[4]);
			ll.add(p);
		}
		scanner.close();
		return ll;
	}
	
	public static void main(String[] args) throws IOException {
/*	
		InputStream fis = new FileInputStream("pedidos.csv");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br =  new BufferedReader(isr);
*/	
		LeitorPedidosCsv LeitorPedidosCsv = new LeitorPedidosCsv();
		List<PedidoCsv> l = LeitorPedidosCsv.leituraPedidosCsv();
		
		
//		String linha = br.readLine();
//		int i = 0;
//		while(linha != null) {
//			var s = linha.split(",");
//			if (i>0) {
//				PedidoCsv p = new PedidoCsv(s[0], s[1], s[5], s[2], s[3], s[4]);
//				l.add(p);
//			}
//            System.out.println(linha);
//            linha = br.readLine();
//            i++;
//		}

//		System.out.println(linha);
		System.out.println("Total de pedidos é: "+l.size());
		
//		br.close();
		
		
	}
	
	
}

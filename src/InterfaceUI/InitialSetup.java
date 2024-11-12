package InterfaceUI;

import java.util.Scanner;

import dados.Estoque;
import dados.GerirEstoque;
import dados.GerirPedidos;
import dados.RegistroPedidos;
import negocios.Gerente;
import negocios.Produto;
import negocios.Vendedor;

public class InitialSetup {
	public static Gerente  initialSetup() {
		Produto prod1 = new Produto("Detergente",2.5,10);
		Produto prod2 = new Produto("Batata chips",5.0,20);
		Produto prod3 = new Produto("Refrigerante 2l",10.0,5);
		Produto prod4 = new Produto("Macarrão",3.5,17);
		
		Estoque estoque = new Estoque();
		
		GerirEstoque gerirEstoque = new GerirEstoque(estoque);
		

		RegistroPedidos registroPedidos = new RegistroPedidos();
		
		GerirPedidos gerirPedidos = new GerirPedidos(registroPedidos);
		
		
		Gerente gerente = new Gerente(gerirEstoque,"Gerente 1", 12345,gerirPedidos);
		
		
		gerente.AdicionarProduto(prod1);
		gerente.AdicionarProduto(prod2);
		gerente.AdicionarProduto(prod3);
		gerente.AdicionarProduto(prod4);
		
		gerirEstoque.AdicionarFuncionario(gerente);
		Vendedor vendedor = new Vendedor(gerirPedidos,"Vendedor 1",12345);
		
		gerente.AdicionarFuncionario(vendedor);
		
		listarProduto(gerente);
		listarFuncionario(gerente);
		return gerente;
	}
	
	
	
	public static void listarProduto(Gerente gerente) {
		gerente.ListarProduto();
	}
	
	public static void listarFuncionario(Gerente gerente) {
		gerente.ListarFuncionario();
	}
}

package InterfaceUI;

import java.util.Scanner;

import dados.Carrinho;
import dados.GerirProdutoPratileira;
import negocios.Cliente;
import negocios.Funcionario;
import negocios.Gerente;
import negocios.Produto;
import negocios.Vendedor;

public class UI {
	
	public static void Menu() {
		System.out.println("--------------------------");
		System.out.println("---------1:Menu Cliente----------------");
		System.out.println("---------2:Menu Gerente----------------");
		System.out.println("---------3:Menu Vendedor----------------");
		System.out.println("---------4:Sair----------------");

	}
	
	
	public static void menuCliente() {
		System.out.println("------------1:Adicionar Produto no carrinho----------------------------");
		System.out.println("------------2:Remover Produto no carrinho----------------------------");
		System.out.println("------------3:Ver Produtos no carrinho----------------------------");
		System.out.println("------------4:Sair----------------------------");


	}
	
	public static void menuVendedor() {
		System.out.println("------------1:Criar pedido----------------------------");
		System.out.println("------------2:Cancelar pedido----------------------------");
		System.out.println("------------3:Realizar venda----------------------------");

	}
	
	public static void menuGerente() {
		System.out.println("------------1:Adicionar Produto no estoque----------------------------");
		System.out.println("------------2:Remover Produto do estoque----------------------------");
		System.out.println("------------3:Adicionar Funcionário no estoque----------------------------");
		System.out.println("------------4:Remover Funcionário do estoque----------------------------");
		System.out.println("------------5:Atualizar Produto no estoque----------------------------");
		System.out.println("------------6:Atualizar Funcionário do estoque----------------------------");
		System.out.println("------------7:Listar Funcionários e produtos----------------------------");
		
	}

	public static void main(String[] args) {

		Scanner sc  = new Scanner(System.in);
		Boolean sair = false;
		Integer opcao = 0;
		Integer opcaoInternaCliente = 0;
		Integer opcaoInternaGerente = 0;
		Integer opcaoInternaVendedor = 0;
		Carrinho carrinho = new Carrinho();
		Cliente cliente = null;
		Gerente gerente = InitialSetup.initialSetup();
		GerirProdutoPratileira gerirProdutoPratileira = new GerirProdutoPratileira(gerente.getEstoque());

		while(!sair) {
	
			Menu();
			opcao = sc.nextInt();
			switch(opcao) {
				case 1:{
					Boolean sairMenuCliente = false;
					System.out.println("Digite um nome: ");
					String nome = sc.next();
					cliente = new Cliente(carrinho,nome,gerirProdutoPratileira);
					while(!sairMenuCliente) {
						menuCliente(); // Ao entrar no menu cliente vou interpretar como se um novo cliente estivesse entrando no estoque, então realize toda as ações antes de sair do menu cliente
						opcaoInternaCliente = sc.nextInt();
						switch(opcaoInternaCliente) {
							case 1:{
								InitialSetup.listarProduto(gerente);
								System.out.println("Digite o id do produto: ");
								Integer prodId = sc.nextInt();
								System.out.println("Digite a quantidade de produtos : ");
								Integer quantidade = sc.nextInt();
								cliente.AdicionarProduto(prodId, quantidade);
								System.out.println("Produto adicionado!");
								break;
							}
							case 2: {
								System.out.println(cliente.getCarrinho());
								System.out.println("Digite o id do produto: ");
								Integer prodId = sc.nextInt();
								cliente.RemoverProduto(prodId);
								break;
							}
							case 3: {
								System.out.println(cliente.getCarrinho());
								break;
							}
							case 4: {
								sairMenuCliente = true;
								break;
							}
							default:{
								System.out.println("Opção inválida");
							}
						}
					}
					break;
				}
				case 2:{
					Boolean sairMenuGerente = false;
					while(!sairMenuGerente) {
						menuGerente();
						opcaoInternaGerente = sc.nextInt();
						switch(opcaoInternaGerente) {
							case 1:{
								System.out.println("Digite o nome do produto: ");
								String nome = sc.next();
								System.out.println("Digite o preço do produto: ");
								Double preco = sc.nextDouble();
								System.out.println("Digite a quantidade de produtos : ");
								Integer quantidade = sc.nextInt();
								Produto novoProduto = new Produto(nome,preco,quantidade);
								gerente.AdicionarProduto(novoProduto);
								break;
							}
							case 2:{
								System.out.println("Digite o id do produto");
								Integer prodId = sc.nextInt();
								gerente.RemoverProduto(prodId);
								break;
							}
							case 3:{
								System.out.println("Digite o nome do funcionário: ");
								String nome = sc.next();
								System.out.println("Digite a senha do funcionário: ");
								Integer senha = sc.nextInt();
								Funcionario novoFuncionario = new Vendedor(gerente.getGerirPedidos(),nome,senha);
								gerente.AdicionarFuncionario(novoFuncionario);
								break;
							}
							case 4:{
								InitialSetup.listarFuncionario(gerente);
								System.out.println("Digite o id do funcionário: ");
								Integer funId = sc.nextInt();
								gerente.RemoverFuncionario(funId);
								break;
							}
							case 5:{
								InitialSetup.listarProduto(gerente);
								System.out.println("Digite o novo nome do Produto : ");
								String novoNome = sc.next();
								System.out.println("Digite o novo preço do Produto: ");
								Double novoPreco = sc.nextDouble();
								System.out.println("Digite a nova quantidade que vai ser adicionada a já existente: ");
								Integer novaQuantidade = sc.nextInt();
								
								Produto produtoAtualizado = new Produto(novoNome,novoPreco,novaQuantidade);
								
								System.out.println("Digite o código do produto que vai ser atualizado: ");
								Integer codProd = sc.nextInt();
								
								gerente.AtualizarProduto(codProd, produtoAtualizado);
								break;
							}
							
							case 6:{
								InitialSetup.listarFuncionario(gerente);
								System.out.println("Digite o novo nome do Funcionario : ");
								String novoNome = sc.next();
								System.out.println("Digite a nova senha do Funcionário: ");
								Integer novaSenha = sc.nextInt();
								
								Vendedor funcionarioAtualizado = new Vendedor(gerente.getGerirPedidos(),novoNome,novaSenha);
								
								System.out.println("Digite o código do funcionário que vai ser atualizado: ");
								Integer codFun = sc.nextInt();
								
								gerente.AtualizarFuncionario(codFun, funcionarioAtualizado);
								break;
							}
							case 7:{
								InitialSetup.listarFuncionario(gerente);
								InitialSetup.listarProduto(gerente);
								break;
							}
							case 8:{
								sairMenuGerente = true;
								break;
							}
							default:{
								System.out.println("Digite um opção válida!");
							}
							
						}
					}
					break;
				}
				
				case 5:{
					sair = true;
					break;
				}
			
			}
			
		}
		
		sc.close();

	}

}

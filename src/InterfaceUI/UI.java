package InterfaceUI;

import java.util.Scanner;

import dados.Carrinho;
import dados.GerirProdutoPratileira;
import negocios.Cliente;
import negocios.Funcionario;
import negocios.Gerente;
import negocios.Produto;
import negocios.Vendedor;
import negocios.exceptions.CarrinhoVazioException;
import negocios.exceptions.ClienteNaoEncontradoException;
import negocios.exceptions.ExistenteException;
import negocios.exceptions.NaoExistenteException;
import negocios.exceptions.PedidoNaoExistenteException;

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
		System.out.println("------------4:Sair----------------------------");

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
								try {
									cliente.AdicionarProduto(prodId, quantidade);
									System.out.println("Produto adicionado!");

								}catch(NaoExistenteException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 2: {
								System.out.println(cliente.getCarrinho());
								System.out.println("Digite o id do produto: ");
								Integer prodId = sc.nextInt();
								try {
									cliente.RemoverProduto(prodId);
								}catch(NaoExistenteException e) {
									System.out.println(e.getMessage());
								}
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
								try {
									gerente.AdicionarProduto(novoProduto);

								}catch(ExistenteException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 2:{
								System.out.println("Digite o id do produto");
								Integer prodId = sc.nextInt();
								try {
									gerente.RemoverProduto(prodId);
								}catch(NaoExistenteException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 3:{
								System.out.println("Digite o nome do funcionário: ");
								String nome = sc.next();
								System.out.println("Digite a senha do funcionário: ");
								Integer senha = sc.nextInt();
								Funcionario novoFuncionario = new Vendedor(gerente.getGerirPedidos(),nome,senha);
								try {
									gerente.AdicionarFuncionario(novoFuncionario);

								}catch(ExistenteException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 4:{
								InitialSetup.listarFuncionario(gerente);
								System.out.println("Digite o id do funcionário: ");
								Integer funId = sc.nextInt();
								try {
								gerente.RemoverFuncionario(funId);
								}catch(NaoExistenteException e) {
									System.out.println(e.getMessage());
								}
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
								
								try {
									gerente.AtualizarProduto(codProd, produtoAtualizado);

								}catch(NaoExistenteException e) {
									System.out.println(e.getMessage());
								}
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
								
								try {
									gerente.AtualizarFuncionario(codFun, funcionarioAtualizado);

								}catch(NaoExistenteException e) {
									System.out.println(e.getMessage());
								}
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
				case 3:{
					Boolean sairMenuVendedor = false;
					InitialSetup.listarFuncionario(gerente);
					System.out.println("Digite o id do vendedor");
					Integer codVendedor = sc.nextInt();
					Vendedor vendedor = (Vendedor) gerente.getFuncionario(codVendedor);
					while(!sairMenuVendedor) {
						menuVendedor();
						opcaoInternaVendedor = sc.nextInt();

						switch(opcaoInternaVendedor) {
							case 1:{
								try {
									vendedor.criarPedido(cliente);
								}catch(CarrinhoVazioException e) {
									System.out.println(e.getMessage());
								}catch(ClienteNaoEncontradoException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 2:{
								System.out.println("Digite o id do pedido: ");
								Integer codPedido = sc.nextInt();
								try {
									vendedor.CancelarPedido(codPedido, gerente);
								}catch(PedidoNaoExistenteException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 3:{
								System.out.println("Digite o id do pedido: ");
								Integer codPedido = sc.nextInt();
								try {
									vendedor.RealizarVenda(codPedido, cliente);
								}catch(PedidoNaoExistenteException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 4:{
								sairMenuVendedor = true;
								
								break;
							}
							default:{
								System.out.println("Digite um opção válida!");
							}
						}
					}
					break;
				}
				
				case 4:{
					sair = true;
					break;
				}
				default:{
					System.out.println("Digite um opção válida!");
					break;
				}
			
			}
			
		}
		
		sc.close();

	}

}

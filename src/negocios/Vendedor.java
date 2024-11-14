package negocios;

import dados.Carrinho;
import dados.GerirPedidos;
import negocios.enums.StatusPagamento;
import negocios.exceptions.CarrinhoVazioException;
import negocios.exceptions.ClienteNaoEncontradoException;
import negocios.exceptions.FalhaNoPagamentoException;
import negocios.exceptions.PedidoNaoExistenteException;

public class Vendedor extends Funcionario{
	GerirPedidos gerirPedidos;
	
	public Vendedor() {}
	
	public Vendedor(GerirPedidos gerirPedidos, String nome, Integer senha) {
		super(nome,senha);
		this.gerirPedidos = gerirPedidos;
	}
	
	public void criarPedido(Cliente cliente) {
		if(cliente != null) {
			Carrinho carrinho = cliente.getCarrinho();
			if(carrinho != null) {
			Pedido pedido = new Pedido(cliente.getCarrinho());
			gerirPedidos.Adicionar(pedido);
			System.out.println("Pedido criado: ");
			System.out.println(pedido);
			}else {
				throw new CarrinhoVazioException("É preciso adicionar items ao carrinho!");
			}
		}else {
			throw new ClienteNaoEncontradoException("É preciso primeiro criar um cliente");
		}
	}
	
	public void RealizarVenda(Integer id,Cliente cliente) {
		Pedido pedido = gerirPedidos.buscarPedidoAberto(id);
		System.out.println("Por favor, pague o pedido: ");
		System.out.printf("Preço total: %.2f %n", pedido.getPrecoTotal());
		cliente.PagarPedido(pedido);
		System.out.println(pedido.getServicoPagamento().realizarPagamento());
		if (pedido.getServicoPagamento().realizarPagamento().equals("Pagamento Realizado!")){
			pedido.setStatusPagamento(StatusPagamento.EFETUADO);
			gerirPedidos.AdicionarPedidoFechado(pedido);
			gerirPedidos.Remover(id);
			System.out.println("Obrigado pela preferência");
			cliente.limparCarrinho();
			System.out.println(pedido);
		}else {
			pedido.setStatusPagamento(StatusPagamento.CANCELADO);
			throw new FalhaNoPagamentoException("Ocorreu um erro ao realizar o pagamento!");
		}
	}
	
	public void CancelarPedido(Integer id,Gerente gerente) {
		Pedido pedido = gerirPedidos.buscarPedidoAberto(id);
		if(pedido != null) {
			for(Produto prod : pedido.getCarrinho().getProdutos()) {
				Produto novoProd = new Produto(prod.getNome(),prod.getPreco(),prod.getQuantidade());
				gerente.AtualizarProduto(prod.getId(), novoProd);
			}
			gerirPedidos.Remover(id);
			System.out.println("Pedido cancelado!");
		}else {
			throw new PedidoNaoExistenteException("Esse pedido não existe!");
		}
	}
	
	public GerirPedidos getGerirPedidos() {
		return gerirPedidos;
	}
}

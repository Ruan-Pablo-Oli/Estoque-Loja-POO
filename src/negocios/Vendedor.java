package negocios;

import dados.GerirPedidos;
import negocios.enums.StatusPagamento;
import negocios.exceptions.FalhaNoPagamentoException;

public class Vendedor extends Funcionario{
	GerirPedidos gerirPedidos;
	
	public Vendedor() {}
	
	public Vendedor(GerirPedidos gerirPedidos, String nome, Integer senha) {
		super(nome,senha);
		this.gerirPedidos = gerirPedidos;
	}
	
	public void criarPedido(Cliente cliente) {
		Pedido pedido = new Pedido(cliente.getCarrinho());
		gerirPedidos.AdicionarPedidoAberto(pedido);
		System.out.println("Pedido criado: ");
		System.out.println(pedido);
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
			gerirPedidos.RemoverPedidoAberto(pedido.getId());
			System.out.println("Obrigado pela preferência");
			cliente.limparCarrinho();
		}else {
			pedido.setStatusPagamento(StatusPagamento.CANCELADO);
			throw new FalhaNoPagamentoException("Ocorreu um erro ao realizar o pagamento!");
		}
	}
	
	public void CancelarPedido(Integer id,Gerente gerente) {
		Pedido pedido = gerirPedidos.buscarPedidoAberto(id);
		for(Produto prod : pedido.getCarrinho().getProdutos()) {
			Produto novoProd = new Produto(prod.getNome(),prod.getPreco(),prod.getQuantidade());
			gerente.AtualizarProduto(prod.getId(), novoProd);
		}
		gerirPedidos.RemoverPedidoAberto(id);
		System.out.println("Pedido cancelado!");
	}
	
	public GerirPedidos getGerirPedidos() {
		return gerirPedidos;
	}
}

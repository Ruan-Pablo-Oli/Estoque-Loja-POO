package dados;

import dados.interfaces.IRepository;
import negocios.Pedido;
import negocios.exceptions.PedidoNaoExistenteException;

public class GerirPedidos implements IRepository<Pedido> {
	private RegistroPedidos registroPedidos;
	
	public GerirPedidos(RegistroPedidos registroPedidos) {
		this.registroPedidos = registroPedidos;
	}
	public void Adicionar(Pedido Pedido) {

		if(Pedido != null && buscarPedidoAberto(Pedido.getId()) == null) {
			registroPedidos.getPedidosAbertos().add(Pedido);
		}
	}

	public void Remover(Integer id) {
		Pedido Pedido = buscarPedidoAberto(id);
		if(Pedido != null) {
			registroPedidos.getPedidosAbertos().remove(Pedido);
		}
	}
	
	public void Listar() {
		for(Pedido pedido : registroPedidos.getPedidosAbertos()) {
			System.out.println(pedido);
		}
	}
	
	public void Atualizar(Integer id, Pedido PedidoAtualizado) {
		Pedido PedidoDesatualizado = buscarPedidoAberto(id);
		
		PedidoDesatualizado.setServicoPagamento(PedidoAtualizado.getServicoPagamento() != null ? PedidoAtualizado.getServicoPagamento() : PedidoDesatualizado.getServicoPagamento());
		PedidoDesatualizado.setStatusPagamento(PedidoAtualizado.getStatusPagamento() != null ? PedidoAtualizado.getStatusPagamento() : PedidoDesatualizado.getStatusPagamento());
	}

	public Pedido buscarPedidoAberto(Integer id) {
		Pedido PedidoEncontrado = registroPedidos.getPedidosAbertos().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		return PedidoEncontrado;
	}
	
	
	public void AdicionarPedidoFechado(Pedido Pedido) {
		if(Pedido != null && buscarPedidoFechado(Pedido.getId()) == null) {
			registroPedidos.getPedidosFechados().add(Pedido);
		}else {
			throw new PedidoNaoExistenteException("Não foi encontrado esse pedido!");
		}
	}
	
	public void RemoverPedidoFechado(Integer id) {
		Pedido Pedido = buscarPedidoFechado(id);
		if(Pedido != null) {
			registroPedidos.getPedidosFechados().remove(Pedido);
		}
	}
	
	public void ListarPedidosFechado() {
		for(Pedido pedido : registroPedidos.getPedidosFechados()) {
			System.out.println(pedido);
		}
	}


	private Pedido buscarPedidoFechado(Integer id) {
		Pedido PedidoEncontrado = registroPedidos.getPedidosFechados().stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
		return PedidoEncontrado;
		}
}

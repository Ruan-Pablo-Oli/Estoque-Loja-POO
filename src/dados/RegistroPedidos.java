package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Pedido;

public class RegistroPedidos {
	private List<Pedido> pedidosAbertos = new ArrayList<>();
	private List<Pedido> pedidosFechados = new ArrayList<>();
	
	public RegistroPedidos() {}

	public List<Pedido> getPedidosAbertos() {
		return pedidosAbertos;
	}

	public List<Pedido> getPedidosFechados() {
		return pedidosFechados;
	}
	
	
}

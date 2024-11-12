package negocios;

import java.util.Objects;

import dados.Carrinho;
import negocios.enums.StatusPagamento;
import negocios.interfaces.ServicoPagamento;

public class Pedido {
	private Integer id;
	private Double precoTotal;
	private ServicoPagamento servicoPagamento = null;
	Carrinho carrinho;
	StatusPagamento statusPagamento;
	
	public Pedido() {}
	
	public Pedido(Carrinho carrinho) {
		this.carrinho = carrinho;
		statusPagamento = StatusPagamento.AGUARDANDO_PAGAMENTO;
		precoTotal = calculaPrecoTotal();
		this.id = (int)(Math.random() * (2500 - 2000 + 1) + 2000);
	}

	
	public ServicoPagamento getServicoPagamento() {
		return servicoPagamento;
	}

	public void setServicoPagamento(ServicoPagamento servicoPagamento) {
		this.servicoPagamento = servicoPagamento;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	public Integer getId() {
		return id;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	private Double calculaPrecoTotal() {
		Double total = 0.0;
		for(Produto prod : carrinho.getProdutos()) {
			total += prod.calculaTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder bg = new StringBuilder();
		
		for(Produto prod: carrinho.getProdutos()) {
			bg.append(prod);
			bg.append(String.format("%n"));
		}
		
		
		return "Pedido [id=" + id + ", precoTotal=" + precoTotal + ", servicoPagamento=" + servicoPagamento
				+ ", statusPagamento=" + statusPagamento + "]" + String.format("%n") + bg.toString();
	}
	
	
	
	
}

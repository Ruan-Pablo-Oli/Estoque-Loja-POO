package negocios;

import java.util.Objects;

import dados.Carrinho;
import dados.GerirProdutoPratileira;
import negocios.exceptions.NaoExistenteException;
import negocios.interfaces.ServicoPagamento;

public class Cliente {
	private Integer id;
	private Carrinho carrinho;
	private String nome;
	private GerirProdutoPratileira gerirPrateleira;
	
	public Cliente(Carrinho carrinho, String nome, GerirProdutoPratileira gerirPrateleira) {
		super();
		this.carrinho = carrinho;
		this.nome = nome;
		this.id = (int)(Math.random() * (1500 - 1001 + 1) + 1001);
		this.gerirPrateleira = gerirPrateleira;
	}


	public Carrinho getCarrinho() {
		return carrinho;
	}


	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getId() {
		return id;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	public void AdicionarProduto(Integer id, Integer quantidade){
		Produto produtoEncontrado = gerirPrateleira.PegarProduto(id);
		if(produtoEncontrado != null) {
			produtoEncontrado.setQuantidade(produtoEncontrado.getQuantidade() - quantidade);
			Produto produtoPendente = new Produto(produtoEncontrado.getNome(),produtoEncontrado.getPreco(),quantidade);
			produtoPendente.setId(produtoEncontrado.getId());
			carrinho.getProdutos().add(produtoPendente);
		}else {
			throw new NaoExistenteException("Produto não encontrado!");
		}
	}
	
	public void RemoverProduto(Integer id) {
		Produto produtoEncontrado = carrinho.getProdutos().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		if(produtoEncontrado != null) {
			carrinho.getProdutos().remove(produtoEncontrado);
		}else {
			throw new NaoExistenteException("Produto não encontrado!");
		}
	}
	
	
	public void PagarPedido(Pedido pedido) {
		ServicoPagamento pagamentoPix = new PagamentoPix();
		
		pedido.setServicoPagamento(pagamentoPix);
	}


	public void limparCarrinho() {
		carrinho.getProdutos().clear();
	}
	
	
	
	
	
	
	
}

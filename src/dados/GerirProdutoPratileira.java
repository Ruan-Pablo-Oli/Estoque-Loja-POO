package dados;

import negocios.Produto;

public class GerirProdutoPratileira {
	private Estoque estoque;
	
	public GerirProdutoPratileira(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public Produto PegarProduto(Integer id) {
		Produto produtoEncontrado = estoque.getProdutos().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		return produtoEncontrado;
	} 
}

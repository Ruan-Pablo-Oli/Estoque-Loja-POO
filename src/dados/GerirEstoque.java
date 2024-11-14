package dados;

import dados.interfaces.IRepository;
import negocios.Produto;
import negocios.exceptions.ExistenteException;
import negocios.exceptions.NaoExistenteException;

public class GerirEstoque implements IRepository<Produto> {
	private Estoque estoque;
	
	public GerirEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}
	
	@Override
	public void Adicionar(Produto produto) {

		if(produto != null && buscarProduto(( produto).getId()) == null) {
			estoque.getProdutos().add(produto);
		}else {
			throw new ExistenteException("Esse produto já está no estoque!");
		}
	}

	@Override
	public void Remover(Integer id) {
		Produto produto = buscarProduto(id);
		if(produto != null) {
			estoque.getProdutos().remove(produto);
		}else {
			throw new NaoExistenteException("Esse produto não está no estoque!");
		}
	}
	
	public void Listar() {
		for(Produto prod : estoque.getProdutos()) {
			System.out.println(prod);
		}
	}
	
	@Override
	public  void Atualizar(Integer id, Produto produtoAtualizado) {
		Produto produtoDesatualizado = buscarProduto(id);
		
		if(produtoDesatualizado != null) {
		produtoDesatualizado.setNome(produtoAtualizado.getNome() != null ? produtoAtualizado.getNome() : produtoDesatualizado.getNome());
		produtoDesatualizado.setPreco(produtoAtualizado.getPreco() != null ? produtoAtualizado.getPreco() : produtoDesatualizado.getPreco());
		produtoDesatualizado.setQuantidade(produtoAtualizado.getQuantidade() != null ? produtoAtualizado.getQuantidade() + produtoAtualizado.getQuantidade(): produtoDesatualizado.getQuantidade());
		}else {
			throw new NaoExistenteException("Esse produto não está no estoque!");
		}
	}

	private Produto buscarProduto(Integer id) {
		Produto produtoEncontrado = estoque.getProdutos().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		return produtoEncontrado;
	}


}

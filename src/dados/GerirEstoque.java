package dados;

import negocios.Funcionario;
import negocios.Produto;

public class GerirEstoque {
	private Estoque estoque;
	
	public GerirEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}
	
	public void AdicionarProduto(Produto produto) {
		if(produto != null && buscarProduto(produto.getId()) == null) {
			estoque.getProdutos().add(produto);
		}
	}

	public void RemoverProduto(Integer id) {
		Produto produto = buscarProduto(id);
		if(produto != null) {
			estoque.getProdutos().remove(produto);
		}
	}
	
	public void ListarProdutos() {
		for(Produto prod : estoque.getProdutos()) {
			System.out.println(prod);
		}
	}
	
	public void AtualizarProduto(Integer id, Produto produtoAtualizado) {
		Produto produtoDesatualizado = buscarProduto(id);
		
		produtoDesatualizado.setNome(produtoAtualizado.getNome() != null ? produtoAtualizado.getNome() : produtoDesatualizado.getNome());
		produtoDesatualizado.setPreco(produtoAtualizado.getPreco() != null ? produtoAtualizado.getPreco() : produtoDesatualizado.getPreco());
		produtoDesatualizado.setQuantidade(produtoAtualizado.getQuantidade() != null ? produtoAtualizado.getQuantidade() + produtoAtualizado.getQuantidade(): produtoDesatualizado.getQuantidade());

	}

	private Produto buscarProduto(Integer id) {
		Produto produtoEncontrado = estoque.getProdutos().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
		return produtoEncontrado;
	}
	
	
	public void AdicionarFuncionario(Funcionario Funcionario) {
		if(Funcionario != null && buscarFuncionario(Funcionario.getId()) == null) {
			estoque.getFuncionarios().add(Funcionario);
		}
	}
	
	public void RemoverFuncionario(Integer id) {
		Funcionario Funcionario = buscarFuncionario(id);
		if(Funcionario != null) {
			estoque.getFuncionarios().remove(Funcionario);
		}
	}
	
	public void ListarFuncionarios() {
		for(Funcionario prod : estoque.getFuncionarios()) {
			System.out.println(prod);
		}
	}
	
	public void AtualizarFuncionario(Integer id, Funcionario FuncionarioAtualizado) {
		Funcionario FuncionarioDesatualizado = buscarFuncionario(id);
		FuncionarioDesatualizado.setNome(FuncionarioAtualizado.getNome() != null ? FuncionarioAtualizado.getNome() : FuncionarioDesatualizado.getNome());
		FuncionarioDesatualizado.setSenha(FuncionarioAtualizado.getSenha() != null ? FuncionarioAtualizado.getSenha() : FuncionarioDesatualizado.getSenha());

	}

	public  Funcionario buscarFuncionario(Integer id) {
		Funcionario funcionarioEncontrado = estoque.getFuncionarios().stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
		return funcionarioEncontrado;
		}
}

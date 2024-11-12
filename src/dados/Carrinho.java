package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Produto;

public class Carrinho {
	
	private List<Produto> produtos  = new ArrayList<Produto>();
	
	public Carrinho() {}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		StringBuilder bg = new StringBuilder();
		for(Produto produto : produtos) {
			bg.append(produto);
			bg.append(String.format("%n "));
		}
		
		return bg.toString();
	}
	
	
	
	
	
	
}

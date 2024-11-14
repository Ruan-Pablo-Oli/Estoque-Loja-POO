package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Produto;

public class Estoque {
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Estoque() {
		
	}

	protected List<Produto> getProdutos() {
		return produtos;
	}


}

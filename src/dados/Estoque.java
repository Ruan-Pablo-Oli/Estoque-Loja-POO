package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Funcionario;
import negocios.Produto;

public class Estoque {
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Estoque() {
		
	}

	protected List<Produto> getProdutos() {
		return produtos;
	}

	protected List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	

}

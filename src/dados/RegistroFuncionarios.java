package dados;

import java.util.ArrayList;
import java.util.List;

import negocios.Funcionario;

public class RegistroFuncionarios {
	List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public RegistroFuncionarios() {}
	
	public List<Funcionario> getFuncionarios () {
		return funcionarios;
	}
	
}

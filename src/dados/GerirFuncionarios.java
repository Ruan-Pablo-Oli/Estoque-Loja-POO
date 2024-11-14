package dados;

import dados.interfaces.IRepository;
import negocios.Funcionario;
import negocios.exceptions.ExistenteException;
import negocios.exceptions.NaoExistenteException;

public class GerirFuncionarios implements IRepository<Funcionario> {
	
	private RegistroFuncionarios  registroFuncionarios;
	
	public GerirFuncionarios(RegistroFuncionarios registroFuncionarios) {
		this.registroFuncionarios = registroFuncionarios;
	}
	
	public void Adicionar(Funcionario Funcionario) {
		if(Funcionario != null && buscarFuncionario(Funcionario.getId()) == null) {
			registroFuncionarios.getFuncionarios().add(Funcionario);
		}else {
			throw new ExistenteException("Esse funcionário já existe!");
		}
	}
	
	public void Remover(Integer id) {
		Funcionario Funcionario = buscarFuncionario(id);
		if(Funcionario != null) {
			registroFuncionarios.getFuncionarios().remove(Funcionario);
		}else {
			throw new NaoExistenteException("Esse funcionário não existe!");
		}
	}
	
	public void Listar() {
		for(Funcionario prod : registroFuncionarios.getFuncionarios()) {
			System.out.println(prod);
		}
	}
	
	public void Atualizar(Integer id, Funcionario FuncionarioAtualizado) {
		Funcionario FuncionarioDesatualizado = buscarFuncionario(id);
		if(FuncionarioDesatualizado != null) {
		FuncionarioDesatualizado.setNome(FuncionarioAtualizado.getNome() != null ? FuncionarioAtualizado.getNome() : FuncionarioDesatualizado.getNome());
		FuncionarioDesatualizado.setSenha(FuncionarioAtualizado.getSenha() != null ? FuncionarioAtualizado.getSenha() : FuncionarioDesatualizado.getSenha());
		}else {
			throw new NaoExistenteException("Esse funcionário não existe!");
		}
	}

	public  Funcionario buscarFuncionario(Integer id) {
		Funcionario funcionarioEncontrado = registroFuncionarios.getFuncionarios().stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
		return funcionarioEncontrado;
		}
}

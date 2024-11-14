package negocios;

import dados.Estoque;
import dados.GerirEstoque;
import dados.GerirFuncionarios;
import dados.GerirPedidos;

public class Gerente extends Funcionario {
	private GerirEstoque repProdutos;
	private GerirPedidos repPedidos;
	private GerirFuncionarios repFuncionarios;
	
	public Gerente() {}
	
	public Gerente(GerirEstoque repProdutos,String nome, Integer senha,GerirPedidos repPedidos,GerirFuncionarios repFuncionarios) {
		super(nome,senha);
		this.repProdutos = repProdutos;
		this.repPedidos = repPedidos;
		this.repFuncionarios = repFuncionarios;
	}
	
	public void AdicionarProduto(Produto produto) {
		repProdutos.Adicionar(produto);
	}
	
	public void RemoverProduto(Integer id) {
		repProdutos.Remover(id);
	}
	
	public void ListarProduto() {
		repProdutos.Listar();
	}
	
	public void AtualizarProduto(Integer id,Produto produto) {
		repProdutos.Atualizar(id,produto);
	}
	
	public Funcionario getFuncionario(Integer id) {
		return repFuncionarios.buscarFuncionario(id);
	}
	
	public void AdicionarFuncionario(Funcionario Funcionario) {
		repFuncionarios.Adicionar(Funcionario);
	}
	
	public void RemoverFuncionario(Integer id) {
		repFuncionarios.Remover(id);
	}
	
	public void ListarFuncionario() {
		repFuncionarios.Listar();
	}
	
	public void AtualizarFuncionario(Integer id,Funcionario Funcionario) {
		repFuncionarios.Atualizar(id,Funcionario);
	}
	
	public Estoque getEstoque() {
		return repProdutos.getEstoque();
	}
	
	public GerirPedidos getGerirPedidos() {
		return repPedidos;
	}
}

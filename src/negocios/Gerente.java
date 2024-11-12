package negocios;

import dados.Estoque;
import dados.GerirEstoque;
import dados.GerirPedidos;

public class Gerente extends Funcionario {
	private GerirEstoque rep;
	private GerirPedidos service;
	
	public Gerente() {}
	
	public Gerente(GerirEstoque rep,String nome, Integer senha,GerirPedidos service) {
		super(nome,senha);
		this.rep = rep;
		this.service = service;
	}
	
	public void AdicionarProduto(Produto produto) {
		rep.AdicionarProduto(produto);
	}
	
	public void RemoverProduto(Integer id) {
		rep.RemoverProduto(id);
	}
	
	public void ListarProduto() {
		rep.ListarProdutos();
	}
	
	public void AtualizarProduto(Integer id,Produto produto) {
		rep.AtualizarProduto(id,produto);
	}
	
	public Funcionario getFuncionario(Integer id) {
		return rep.buscarFuncionario(id);
	}
	
	public void AdicionarFuncionario(Funcionario Funcionario) {
		rep.AdicionarFuncionario(Funcionario);
	}
	
	public void RemoverFuncionario(Integer id) {
		rep.RemoverFuncionario(id);
	}
	
	public void ListarFuncionario() {
		rep.ListarFuncionarios();
	}
	
	public void AtualizarFuncionario(Integer id,Funcionario Funcionario) {
		rep.AtualizarFuncionario(id,Funcionario);
	}
	
	public Estoque getEstoque() {
		return rep.getEstoque();
	}
	
	public GerirPedidos getGerirPedidos() {
		return service;
	}
}

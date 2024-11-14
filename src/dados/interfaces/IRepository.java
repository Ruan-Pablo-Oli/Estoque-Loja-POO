package dados.interfaces;


public interface IRepository<T> {

	public  void Adicionar(T item);
	public void Remover(Integer id);
	public void Listar();
	public void Atualizar(Integer id,T itemAtualizado);
	
}

package negocios;

import java.util.Objects;

public abstract class Funcionario {
	private Integer id;
	private String nome;
	private Integer senha;
	
	public Funcionario() {}

	public Funcionario(String nome, Integer senha) {
		super();
		this.nome = nome;
		this.senha = senha;
		id = (int)(Math.random() * (1000 - 500 + 1) + 500);
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	
	
	
	
	
}

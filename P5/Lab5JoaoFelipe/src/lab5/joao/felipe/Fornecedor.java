package lab5.joao.felipe;

import java.util.HashSet;
import java.util.Set;

public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private Set<Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashSet<Produto>();
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String listaProdutos() {
		String msg = "";
		for(Produto a : this.produtos) {
			msg += this.nome + " - " + a.toString() + " | ";
		}
		msg = msg.substring(0, msg.length()-3);
		return msg;
	}

	@Override
	public String toString() {
		String msg = this.nome + " - " + this.email + " - " + this.telefone;
		return msg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}

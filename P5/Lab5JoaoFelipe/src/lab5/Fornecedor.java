package lab5;

import java.util.HashSet;
import java.util.Set;

public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private Set<Produto> produtos;
	
	public Fornecedor(String nome, String email, String telefone) {
		if(nome == null || email == null || telefone == null) {
			throw new NullPointerException("Nome, email ou telefone nulo");
		}else if("".equals(nome) || "".equals(email) || "".equals(telefone)) {
			throw new IllegalArgumentException("Nome, email ou telefone invalido");
		}
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

	public boolean cadastraProduto(Produto p) {
		if(!this.produtos.contains(p)) {
			this.produtos.add(p);
			return true;
		}
		return false;
	}
	
	public boolean removeProduto(String nome) {
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome)) {
				Produto p = produto;
				this.produtos.remove(p);
				return true;
			}
		}return false;
	}
	
	public String imprimeProduto(String nome) {
		boolean achou = false;
		String msg = "";
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome)) {
				achou = true;
				msg = produto.toString();
				break;
			}
		}if (!achou) {
			throw new IllegalArgumentException("Produto nao cadastrado");
		}
		return msg;
	}
	
	public String listaProdutos() {
		String msg = "";
		if(this.produtos.size() < 1) {
			msg = "";
			return msg;
		}
		for(Produto produto : this.produtos) {
			msg += this.nome + " - " + produto.toString() + " | ";
		}msg = msg.substring(0, msg.length()-3);
		return msg;
	}
	
	public boolean editaProduto(String nome, double valor) {
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome)) {
				produto.setPreco(valor);
				return true;
			}
		}return false;
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

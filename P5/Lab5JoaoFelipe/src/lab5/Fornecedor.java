package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Representacao do fornecedor.
 * @author Joao Felipe da Silva Freitas.
 *
 */
public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private Set<Produto> produtos;
	
	/**
	 * Construtoi um novo fornecedor apatir do seu nome, email e telefone.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}else if(email == null || "".equals(email)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}else if(telefone == null || "".equals(telefone)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashSet<>();
	}
	
	/**
	 * Seta um email para o fornecedor.
	 * @param email novo email.
	 */
	public void setEmail(String email) {
		if(email == null || "".equals(email)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		this.email = email;
	}

	/**
	 * Seta um telefone para o fornecedor.
	 * @param telefone novo telefone.
	 */
	public void setTelefone(String telefone) {
		if(telefone == null || "".equals(telefone)) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		this.telefone = telefone;
	}

	/**
	 * Cadastra um novo produto no fornecedor.
	 * @param p objeto do tipo Produto.
	 * @return um booleano caso o produto seja adicionado com sucesso.
	 */
	public boolean cadastraProduto(Produto p) {
		if(this.produtos.contains(p)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		this.produtos.add(p);
		return true;
	}
	
	/**
	 * Remove um produto do fornecedor apartir do nome do produto.
	 * @param nome nome do produto.
	 * @return retorna um booleano True caso o produto seja removido com sucesso.
	 */
	public boolean removeProduto(String nome) {
		boolean flag = false;
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome)) {
				Produto p = produto;
				this.produtos.remove(p);
				flag = true;
				break;
			}
		}
		if (flag) {
			return flag;
		}else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
	}
	
	/**
	 * Exibe um produto apatir do seu nome.
	 * @param nome nome do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
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
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		return msg;
	}
	
	/**
	 * @return uma String em ordem alfabetica com todos produtos cadastrados no fornecedor, no formato PRODUTO - DESCRICAO - PRECO | PRODUTO - DESCRICAO - PRECO.....
	 */
	public String listaProdutos() {
		String msg = "";
		if(this.produtos.size() < 1) {
			msg = "";
			return msg;
		}
		ArrayList<String> auxiliar = new ArrayList<>();
		for(Produto produto : this.produtos) {
			msg = this.nome + " - " + produto.toString() + " | ";
			auxiliar.add(msg);
		}
		Collections.sort(auxiliar);
		msg = "";
		for (int i = 0; i < auxiliar.size(); i++) {
			msg += auxiliar.get(i) ;
		}
		
		msg = msg.substring(0, msg.length()-3);
		return msg;
	}
	
	/**
	 * Edita o preco de um produto apartir do seu nome e do seu novo preco.
	 * @param nome nome do produto.
	 * @param valor novo valor do produto.
	 * @return retorna um booleano True caso a edicao seja um sucesso.
	 */
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

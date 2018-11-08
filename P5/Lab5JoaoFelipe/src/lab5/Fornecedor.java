package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


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
	private Map<String, Conta> contas;
	
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
		this.contas = new TreeMap<>();
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
	 * Cadastra um novo combo no fornecedor.
	 * @param produto nome do combo.
	 * @param descricao descricao do combo.
	 * @param fator fator de desconto.
	 * @param produtosPassados Array de String com nome e descricao dos protudos simples que farao parte do combo.
	 * @return retorna um booleano caso o cadastra do combo for um sucesso.
	 */
	public boolean cadastraCombo(String produto, String descricao, double fator, String[] produtosPassados) {
		if(produto == null || "".equals(produto)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}else if(fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		for (Produto produtosIguais : this.produtos) {
			if(produtosIguais.getNomeProduto().equals(produto+descricao)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
			}
		}		
		Produto p = new ProdutoCombo(produto, descricao, fator, this.arrumaOsProdutosDoCombo(produtosPassados));
		this.produtos.add(p);
		return true;
	}
	
	/**
	 * Procura os produtos simples passados a partir do seu nome e os tranfere para um Array de ProdutosSimples.
	 * @param produtosPassados Array de String com nome e descricao dos produtos.
	 * @return um array de ProtudoSimples.
	 */
	private ProdutoSimples[] arrumaOsProdutosDoCombo(String[] produtosPassados) {
		boolean flag = false;
		ProdutoSimples[] parametros = new ProdutoSimples[produtosPassados.length];
		for (int i = 0; i < produtosPassados.length; i++) {
			String[] dividido = produtosPassados[i].split(" - ");
			for (Produto comida : this.produtos) {
				flag = false;
				if(comida.getNomeProduto().equals(dividido[0]+dividido[1])) {
					try {
						ProdutoSimples p = (ProdutoSimples) comida;
						parametros[i] = p;
						flag = true;
						break;
					}
					catch (ClassCastException e) {
						throw new ClassCastException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
					}	
				}
			}
			if (!flag) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
		}
		return parametros;
	}
	
	/**
	 * Remove um produto do fornecedor apartir do nome do produto.
	 * @param nome nome do produto.
	 * @return retorna um booleano True caso o produto seja removido com sucesso.
	 */
	public boolean removeProduto(String nome, String descricao) {
		boolean flag = false;
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome+descricao)) {
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
	public String imprimeProduto(String nome, String descricao) {
		boolean achou = false;
		String msg = "";
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome+descricao)) {
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
		List<Produto> auxiliar = new ArrayList<>();
		for(Produto p : this.produtos) {
			auxiliar.add(p);
		}
		Collections.sort(auxiliar);
		for (Produto p : auxiliar) {
			msg +=this.nome + " - " + p.toString() + " | ";
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
	public boolean editaProduto(String nome, String descricao, double valor) {
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome+descricao)) {
				produto.setPreco(valor);
				return true;
			}
		}
		throw new IllegalAccessError("Erro na edicao de produto: produto nao existe.");
	}
	
	/**
	 * Edita um combo apartir do seu nome, descricao e novo fator de desconto.
	 * @param nome nome do combo.
	 * @param descricao descricao do combo.
	 * @param valor novo fator de desconto.
	 * @return retorna um booleano caso a edicao do combo seja um sucesso.
	 */
	public boolean editaCombo(String nome, String descricao, double valor) {
		for(Produto produto : this.produtos) {
			if(produto.getNomeProduto().equals(nome+descricao)) {
				produto.setPreco(valor);
				return true;
			}
		}
		throw new IllegalAccessError("Erro na edicao de combo: produto nao existe.");
	}
	
	/**
	 * Adiciona uma nova compra apatir do cpf do cliente, data da compra, nome do produto e descricao do produto.
	 * @param cpf cpf do cliente.
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto,
	 * @return retorna um booleano caso a adicao da compra seja um sucesso.
	 */
	public boolean adicionaCompra(String cpf, String data, String produto, String descricao) {
		boolean flag = false;
		if(data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		for (Produto a : this.produtos) {
			if(a.getNomeProduto().equals(produto+descricao)) {
				flag = true;
				if(this.contas.get(cpf) == null) {
					Conta c = new Conta();
					this.contas.put(cpf, c);
					this.contas.get(cpf).cadastraCompra(data, produto, a.getPreco());
					break;
				}else {
					this.contas.get(cpf).cadastraCompra(data, produto, a.getPreco());
					break;
				}
			}
		}
		if(!flag) {
			throw new IllegalAccessError("Erro ao cadastrar compra: produto nao existe.");
		}
		return true;
	}
	
	/**
	 * Retorna o debito de um determinado cliente.
	 * @param cpf cpf do cliente.
	 * @return retorna um debito do cliente.
	 */
	public String getDebito(String cpf) {
		if(!this.contas.containsKey(cpf)){
			throw new IllegalAccessError("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
		return this.contas.get(cpf).getDebito();
	}
	
	/**
	 * Exibe a conta de um determinado cliente.
	 * @param cpf cpf do cliente.
	 * @return retorna um String no formado NOME-DO-FORNECEDOR | Compras do Cliente.... 
	 */
	public String exibeContas(String cpf) {
		if(!this.contas.containsKey(cpf)){
			throw new IllegalAccessError("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		return this.nome + " | " + this.contas.get(cpf).exibeContas();
	}
	
	public boolean pagaDebito(String cpf) {
		if (!this.contas.containsKey(cpf)) {
			throw new IllegalAccessError("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		}
		this.contas.remove(cpf);
		return true;
	}
	
	/**
	 * Representacao do fornecedor em forma de String.
	 * @return retorna uma representacao do fornecedor no formato NOME - EMAIL - TELEFONE
	 */
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

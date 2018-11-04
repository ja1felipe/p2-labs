package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Sistema controlador dos clientes.
 * @author Joao Felipe da Silva Freitas.
 *
 */
public class SistemaClientes {
	
	private Map<String, Cliente> clientes;

	
	/**
	 * Construtor que inicializa um HashMap de clientes.
	 */
	public SistemaClientes() {
		this.clientes = new HashMap<>();
	}
	
	/**
	 * Adiciona um novo cliente valido apartir do seu cpf, nome, email e localizacao.
	 * 
	 * @param cpf cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param local localizacao do cliente.
	 * @return retorna um booleano True se o cliente for cadastrado com sucesso.
	 */
	public boolean cadastrarCliente(String cpf, String nome, String email, String local) {
		Cliente c = new Cliente(cpf, nome, email, local);
		if (this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}else {
			this.clientes.put(cpf, c);
			return true;
		}
	}
	
	/**
	 * Exibe um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return uma string que representa o cliente no formato NOME - LOCALIZACAO - EMAIL.
	 */
	public String imprimeCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).toString();
	}
	
	/**
	 * Exibe todos clientes cadastrados.
	 * 
	 * @return uma string que representa todos os clientes no formato NOME - LOCALIZACAO - EMAIL | NOME - LOCALIZACAO - EMAIL.
	 */
	public String imprimeTodosClientes() {
		String msg = "";
		if(this.clientes.size() < 1) {
			throw new NullPointerException("Nao ha clientes cadastrados");
		}
		ArrayList<String> c = new ArrayList<>();
		for (String cliente : this.clientes.keySet()) {
			c.add(this.clientes.get(cliente).toString());
		}
		Collections.sort(c);
		for (String d : c) {
			msg += d + " | ";
		}
		msg = msg.substring(0, msg.length()-3);
		return msg;
	}
	
	/**
	 * Remove um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna um booleano True se a remocao do cliente for um sucesso.
	 */
	public boolean removerCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Edita um cliente valido apartir do seu cpf, nome do atributo a ser editado e a novo atributo.
	 * Os atributos validos sao: nome, email e localizacao.
	 * @param cpf cpf do cliente.
	 * @param atributo nome do atributo a ser editado.
	 * @param novo novo atributo.
	 * 
	 * @return retorna um booleando True se a edicao do cliente for um sucesso.
	 */
	public boolean editarCliente(String cpf, String atributo, String novo) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}else if(novo.equals("") || novo == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}else if(atributo.equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		switch (atributo) {
		case ("nome"): 
			this.clientes.get(cpf).setNome(novo);
			return true;
		case("email"):
			this.clientes.get(cpf).setEmail(novo);
		return true;
		case("localizacao"):
			this.clientes.get(cpf).setLocal(novo);
			return true;
		default:
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
	
	public boolean verificaCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			return false;
		}
		return true;
	}
}
	
	


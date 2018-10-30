package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SistemaClientes {
	
	private Map<String, Cliente> clientes;
	
	public SistemaClientes() {
		this.clientes = new HashMap<>();
	}
	
	public boolean cadastrarCliente(String cpf, String nome, String email, String local) {
		Cliente c = new Cliente(cpf, nome, email, local);
		if (this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}else {
			this.clientes.put(cpf, c);
			return true;
		}
	}
	
	public String imprimeCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).toString();
	}
	
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
	
	public boolean removerCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			this.clientes.remove(cpf);
			return true;
		}else {
			return false;
		}
	}
	
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
		case("local"):
			this.clientes.get(cpf).setLocal(novo);
			return true;
		default:
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}
}
	
	


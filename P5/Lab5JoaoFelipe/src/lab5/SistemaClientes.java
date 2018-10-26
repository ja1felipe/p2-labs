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
		if (!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, c);
			return true;
		}else {
			return false;
		}
	}
	
	public String imprimeCliente(String cpf) {
		if (!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Cliente inexistente");
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
	
	public boolean editarCliente(String cpf, String nome, String email, String local) {
		if (this.clientes.containsKey(cpf)) {
			if(!"".equals(nome)) {
				this.clientes.get(cpf).setNome(nome);
			}if(!"".equals(email)) {
				this.clientes.get(cpf).setEmail(email);
			}if(!"".equals(local)) {
				this.clientes.get(cpf).setLocal(local);
			}
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}

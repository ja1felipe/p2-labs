package lab5;

import java.util.Map;
import java.util.TreeMap;

public class SistemaFornecedores {

	private Map<String, Fornecedor> fornecedores;
	
	public SistemaFornecedores() {
		this.fornecedores = new TreeMap<>();
	}
	
	public boolean cadastrarFornecedor(String nome, String email, String telefone) {
		Fornecedor f = new Fornecedor(nome, email, telefone);
		if (!this.fornecedores.containsKey(nome)) {
			this.fornecedores.put(nome, f);
			return true;
		}else {
			return false;
		}
	}
	
	public String imprimeFornecedor(String nome) {
		if(!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(nome).toString();
	}
	
	
	public String imprimeFornecedores() {
		String msg = "";
		if(this.fornecedores.size() < 1) {
			throw new NullPointerException("Nao ha fornecedores cadastrados");
		}
		for (String ordenar : this.fornecedores.keySet()) {
			msg += this.fornecedores.get(ordenar).toString() + " | ";
		}
		msg = msg.substring(0, msg.length()-3);
		return msg;
	}
	
	public boolean removerFornecedor(String nome) {
		if(this.fornecedores.containsKey(nome)) {
			this.fornecedores.remove(nome);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean editarFornecedor(String nome, String email, String telefone) {
		if (this.fornecedores.containsKey(nome)) {
			if(!"".equals(email)) {
				this.fornecedores.get(nome).setEmail(email);
			}if(!"".equals(telefone)) {
				this.fornecedores.get(nome).setTelefone(telefone);
			}
			return true;
		}else {
			return false;
		}
	}
	
	public boolean cadastraProduto(String fornecedor, String produto, String descricao, double valor) {
		Produto p = new Produto(produto, descricao, valor);
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(fornecedor).cadastraProduto(p);
	}
	
	public boolean removerProduto(String fornecedor, String produto) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(fornecedor).removeProduto(produto);
	}
	
	public String imprimeProduto(String fornecedor, String produto) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(fornecedor).imprimeProduto(produto);
	}
	
	public String listaProdutosDeFornecedor(String fornecedor) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(fornecedor).listaProdutos();
	}
	
	public String listaTodosProdutos() {
		String msg = "";
		if(this.fornecedores.size() < 1) {
			throw new NullPointerException();
		}
		for(String f : this.fornecedores.keySet()) {
			if(!this.fornecedores.get(f).listaProdutos().equals("")) {
				msg += this.fornecedores.get(f).listaProdutos() + " | ";
			}
		}
		if("".equals(msg)) {
			throw new NullPointerException();
		}
		return msg.substring(0, msg.length()-3);
	}
	
	public boolean editaProduto(String fornecedor, String produto, double valor) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(fornecedor).editaProduto(produto, valor);
	}
	
}

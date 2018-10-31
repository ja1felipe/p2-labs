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
		if (this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}else {
			this.fornecedores.put(nome, f);
			return true;
		}
	}
	
	public String imprimeFornecedor(String nome) {
		if(!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
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
		if(!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}else {
			this.fornecedores.remove(nome);
			return true;
		}
	}
	
	public boolean editaFornecedor(String nome, String atributo, String novo) {
		if (!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: cliente nao existe.");
		}else if(novo.equals("") || novo == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}else if(atributo.equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		switch (atributo) {
		case ("nome"): 
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		case("email"):
			this.fornecedores.get(nome).setEmail(novo);
		return true;
		case("telefone"):
			this.fornecedores.get(nome).setTelefone(novo);
			return true;
		default:
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	public boolean cadastraProduto(String fornecedor, String produto, String descricao, double valor) {
		
		if(fornecedor == null || "".equals(fornecedor)){
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		Produto p = new Produto(produto, descricao, valor);
		return this.fornecedores.get(fornecedor).cadastraProduto(p);
	}
	
	public boolean removerProduto(String fornecedor, String produto, String descricao) {
		if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}else if(produto == null || "".equals(produto)) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}else if(fornecedor == null || "".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		return this.fornecedores.get(fornecedor).removeProduto(produto);
	}
	
	public String imprimeProduto(String produto, String descricao, String fornecedor) {
		if(produto == null || "".equals(produto)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}else if(fornecedor == null || "".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
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
	
	public boolean editaProduto(String fornecedor, String produto, String descricao, double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}else if(produto == null || "".equals(produto)) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}else if(fornecedor == null || "".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		return this.fornecedores.get(fornecedor).editaProduto(produto, valor);
	}
	
}

package lab5;

import easyaccept.EasyAccept;

public class Facade {
	
	private SistemaClientes sistemaClientes;
	private SistemaFornecedores sistemaFornecedores;
	
	public Facade() {
		this.sistemaClientes = new SistemaClientes();
		this.sistemaFornecedores = new SistemaFornecedores();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String local) {
		sistemaClientes.cadastrarCliente(cpf, nome, email, local);
		return cpf;
	}
	
	public String exibeCliente(String cpf) {
		return sistemaClientes.imprimeCliente(cpf);
	}
	
	public String exibeClientes() {
		return sistemaClientes.imprimeTodosClientes();
	}
	
	public boolean removeCliente(String cpf) {
		return sistemaClientes.removerCliente(cpf);
	}
	
	public boolean editaCliente(String cpf, String atributo, String novo) {
		return sistemaClientes.editarCliente(cpf, atributo, novo);
	}
	
	public boolean cadastrarFornecedor(String nome, String email, String telefone) {
		return sistemaFornecedores.cadastrarFornecedor(nome, email, telefone);
	}
	
	public String imprimeFornecedor(String nome) {
		return sistemaFornecedores.imprimeFornecedor(nome);
	}
	
	public String imprimeFornecedores() {
		return sistemaFornecedores.imprimeFornecedores();
	}
	
	public boolean removerFornecedor(String nome) {
		return sistemaFornecedores.removerFornecedor(nome);
	}
	
	public boolean editarFornecedor(String nome, String email, String telefone) {
		return sistemaFornecedores.editarFornecedor(nome, email, telefone);
	}
	
	public boolean cadastraProduto(String fornecedor, String produto, String descricao, double valor) {
		return sistemaFornecedores.cadastraProduto(fornecedor, produto, descricao, valor);
	}
	
	public boolean removerProduto(String fornecedor, String produto) {
		return sistemaFornecedores.removerProduto(fornecedor, produto);
	}
	
	public String imprimeProduto(String fornecedor, String produto) {
		return sistemaFornecedores.imprimeProduto(fornecedor, produto);
	}
	
	public String listaProdutosDeFornecedor(String fornecedor) {
		return sistemaFornecedores.listaProdutosDeFornecedor(fornecedor);
	}
	
	public String listaTodosProdutos() {
		return sistemaFornecedores.listaTodosProdutos();
	}
	
	public boolean editaProduto(String fornecedor, String produto, double valor) {
		return sistemaFornecedores.editaProduto(fornecedor, produto, valor);
	}
	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "Testes/use_case_1.txt" };
		EasyAccept.main(args);
	}	
}

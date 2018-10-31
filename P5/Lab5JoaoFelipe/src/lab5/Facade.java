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
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		sistemaFornecedores.cadastrarFornecedor(nome, email, telefone);
		return nome;
	}
	
	public String exibeFornecedor(String nome) {
		return sistemaFornecedores.imprimeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return sistemaFornecedores.imprimeFornecedores();
	}
	
	public boolean removeFornecedor(String nome) {
		return sistemaFornecedores.removerFornecedor(nome);
	}
	
	public boolean editaFornecedor(String nome, String email, String telefone) {
		return sistemaFornecedores.editaFornecedor(nome, email, telefone);
	}
	
	public boolean adicionaProduto(String fornecedor, String produto, String descricao, double preco) {
		return sistemaFornecedores.cadastraProduto(fornecedor, produto, descricao, preco);
	}
	
	public boolean removeProduto(String produto, String descricao, String fornecedor) {
		return sistemaFornecedores.removerProduto(fornecedor, produto, descricao);
	}
	
	public String exibeProduto(String produto, String descricao, String fornecedor) {
		return sistemaFornecedores.imprimeProduto(produto, descricao, fornecedor);
	}
	
	public String exibeProdutosFornecedor(String fornecedor) {
		return sistemaFornecedores.listaProdutosDeFornecedor(fornecedor);
	}
	
	public String exibeProdutos() {
		return sistemaFornecedores.listaTodosProdutos();
	}
	
	public boolean editaProduto(String produto, String descricao, String fornecedor, double novoPreco) {
		return sistemaFornecedores.editaProduto(fornecedor, produto, descricao, novoPreco);
	}
	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "Testes/use_case_1.txt", "Testes/use_case_2.txt", "Testes/use_case_3.txt" };
		EasyAccept.main(args);
	}	
}

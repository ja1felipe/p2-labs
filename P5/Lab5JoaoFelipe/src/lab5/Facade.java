package lab5;

public class Facade {
	
	private SistemaClientes sistemaClientes;
	private SistemaFornecedores sistemaFornecedores;
	
	public Facade() {
		this.sistemaClientes = new SistemaClientes();
		this.sistemaFornecedores = new SistemaFornecedores();
	}
	
	public boolean cadastrarCliente(String cpf, String nome, String email, String local) {
		return sistemaClientes.cadastrarCliente(cpf, nome, email, local);
	}
	
	public String imprimeCliente(String cpf) {
		return sistemaClientes.imprimeCliente(cpf);
	}
	
	public String imprimeTodosClientes() {
		return sistemaClientes.imprimeTodosClientes();
	}
	
	public boolean removerCliente(String cpf) {
		return sistemaClientes.removerCliente(cpf);
	}
	
	public boolean editarCliente(String cpf, String nome, String email, String local) {
		return sistemaClientes.editarCliente(cpf, nome, email, local);
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
}

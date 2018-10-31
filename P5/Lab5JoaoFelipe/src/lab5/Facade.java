package lab5;

import easyaccept.EasyAccept;

/**
 * Fachada do programa.
 * @author Joao Felipe da Silva Freitas
 *
 */
public class Facade {
	
	private SistemaClientes sistemaClientes;
	private SistemaFornecedores sistemaFornecedores;
	
	/**
	 * 
	 */
	public Facade() {
		this.sistemaClientes = new SistemaClientes();
		this.sistemaFornecedores = new SistemaFornecedores();
	}
	
	/**
	 * Adiciona um novo cliente valido apartir do seu cpf, nome, email e localizacao.
	 * 
	 * @param cpf cpf do cliente.
	 * @param nome nome do cliente.
	 * @param email email do cliente.
	 * @param local localizacao do cliente.
	 * @return retorna o cpf do cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String local) {
		sistemaClientes.cadastrarCliente(cpf, nome, email, local);
		return cpf;
	}
	
	/**
	 * Exibe um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return uma string que representa o cliente no formato NOME - LOCALIZACAO - EMAIL.
	 */
	public String exibeCliente(String cpf) {
		return sistemaClientes.imprimeCliente(cpf);
	}
	
	/**
	 * Exibe todos clientes cadastrados.
	 * 
	 * @return uma string que representa todos os clientes no formato NOME - LOCALIZACAO - EMAIL | NOME - LOCALIZACAO - EMAIL.
	 */
	public String exibeClientes() {
		return sistemaClientes.imprimeTodosClientes();
	}
	
	/**
	 * Remove um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna um booleano True se a remocao do cliente for um sucesso.
	 */
	public boolean removeCliente(String cpf) {
		return sistemaClientes.removerCliente(cpf);
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
	public boolean editaCliente(String cpf, String atributo, String novo) {
		return sistemaClientes.editarCliente(cpf, atributo, novo);
	}
	
	/**
	 * Adiciona um novo fornecedor valido apartir do seu nome, email e telefone.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 * @return o nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		sistemaFornecedores.cadastrarFornecedor(nome, email, telefone);
		return nome;
	}
	
	/**
	 * Exibe um fornecedor valido apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return uma string que representa o fornecedor no formato NOME - EMAIL - TELEFONE.
	 */
	public String exibeFornecedor(String nome) {
		return sistemaFornecedores.imprimeFornecedor(nome);
	}
	
	/**
	 * Exibe todos fornecedores validos.
	 * @return uma string que representa todos os fornecedores no formato NOME - EMAIL - TELEFONE | NOME - EMAIL - TELEFONE ....
	 */
	public String exibeFornecedores() {
		return sistemaFornecedores.imprimeFornecedores();
	}
	
	/**
	 * Remove um fornecedor apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return retorna um booleano True se a remocao do fornecedor for um sucesso.
	 */
	public boolean removeFornecedor(String nome) {
		return sistemaFornecedores.removerFornecedor(nome);
	}
	
	/**
	 * Edita um fornecedor valido apartir do seu nome, nome do atributo a ser editado e a novo atributo.
	 * Os atributos validos sao: email e telefone.
	 * @param nome nome do fornecedor.
	 * @param atributo atributo a ser editado.
	 * @param novoAtributo novo atributo.
	 * @return retorna a booleano True se a edicao for um sucesso.
	 */
	public boolean editaFornecedor(String nome, String atributo, String novoAtributo) {
		return sistemaFornecedores.editaFornecedor(nome, atributo, novoAtributo);
	}
	
	/**
	 * Adiciona um produto valido para determinado fornecedor.
	 * 
	 * @param fornecedor fornecedor que vai ter aquele produto.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco preco do produto.
	 * @return um booleando True se o produto for adicionado com sucesso.
	 */
	public boolean adicionaProduto(String fornecedor, String produto, String descricao, double preco) {
		return sistemaFornecedores.cadastraProduto(fornecedor, produto, descricao, preco);
	}
	
	/**
	 * Remove um produto valido de um determinado fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @return retorna um booleano True se o produto for removido com sucesso.
	 */
	public boolean removeProduto(String produto, String descricao, String fornecedor) {
		return sistemaFornecedores.removerProduto(fornecedor, produto, descricao);
	}
	
	/**
	 * Exibe um produto apartir do seu nome, descricao e fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
	public String exibeProduto(String produto, String descricao, String fornecedor) {
		return sistemaFornecedores.imprimeProduto(produto, descricao, fornecedor);
	}
	
	/**
	 * Exibe todos produtos de um fornecedor.
	 * @param fornecedor nome do fornecedor.
	 * @return uma String com todos produtos do fornecedor em ordem alfabetica, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return sistemaFornecedores.listaProdutosDeFornecedor(fornecedor);
	}
	
	/**
	 * Exibe todos produtos ja adicionados em ordem alfabetica do seu fornecedor.
	 * @return uma String com todos produtos em ordem alfabetica, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
	public String exibeProdutos() {
		return sistemaFornecedores.listaTodosProdutos();
	}
	
	/**
	 * Edita o preco de um produto apartir do seu nome, descricao, nome do fornecedor e seu novo preco.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @param novoPreco novo preco do produto.
	 * @return um booleano True se o produto for editado com sucesso.
	 */
	public boolean editaProduto(String produto, String descricao, String fornecedor, double novoPreco) {
		return sistemaFornecedores.editaProduto(fornecedor, produto, descricao, novoPreco);
	}
	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "Testes/use_case_1.txt", "Testes/use_case_2.txt", "Testes/use_case_3.txt" };
		EasyAccept.main(args);
	}	
}

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
		this.sistemaClientes.cadastrarCliente(cpf, nome, email, local);
		return cpf;
	}
	
	/**
	 * Exibe um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return uma string que representa o cliente no formato NOME - LOCALIZACAO - EMAIL.
	 */
	public String exibeCliente(String cpf) {
		return this.sistemaClientes.imprimeCliente(cpf);
	}
	
	/**
	 * Exibe todos clientes cadastrados.
	 * 
	 * @return uma string que representa todos os clientes no formato NOME - LOCALIZACAO - EMAIL | NOME - LOCALIZACAO - EMAIL.
	 */
	public String exibeClientes() {
		return this.sistemaClientes.imprimeTodosClientes();
	}
	
	/**
	 * Remove um cliente valido apartir do seu cpf.
	 * 
	 * @param cpf cpf do cliente.
	 * @return retorna um booleano True se a remocao do cliente for um sucesso.
	 */
	public boolean removeCliente(String cpf) {
		return this.sistemaClientes.removerCliente(cpf);
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
		return this.sistemaClientes.editarCliente(cpf, atributo, novo);
	}
	
	/**
	 * Adiciona um novo fornecedor valido apartir do seu nome, email e telefone.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 * @return o nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		this.sistemaFornecedores.cadastrarFornecedor(nome, email, telefone);
		return nome;
	}
	
	/**
	 * Exibe um fornecedor valido apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return uma string que representa o fornecedor no formato NOME - EMAIL - TELEFONE.
	 */
	public String exibeFornecedor(String nome) {
		return this.sistemaFornecedores.imprimeFornecedor(nome);
	}
	
	/**
	 * Exibe todos fornecedores validos.
	 * @return uma string que representa todos os fornecedores no formato NOME - EMAIL - TELEFONE | NOME - EMAIL - TELEFONE ....
	 */
	public String exibeFornecedores() {
		return this.sistemaFornecedores.imprimeFornecedores();
	}
	
	/**
	 * Remove um fornecedor apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return retorna um booleano True se a remocao do fornecedor for um sucesso.
	 */
	public boolean removeFornecedor(String nome) {
		return this.sistemaFornecedores.removerFornecedor(nome);
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
		return this.sistemaFornecedores.editaFornecedor(nome, atributo, novoAtributo);
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
		return this.sistemaFornecedores.cadastraProduto(fornecedor, produto, descricao, preco);
	}
	
	public boolean adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		return this.sistemaFornecedores.cadastraCombo(fornecedor, nome, descricao, fator, produtos);
	}
	
	/**
	 * Remove um produto valido de um determinado fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @return retorna um booleano True se o produto for removido com sucesso.
	 */
	public boolean removeProduto(String produto, String descricao, String fornecedor) {
		return this.sistemaFornecedores.removerProduto(fornecedor, produto, descricao);
	}
	
	/**
	 * Exibe um produto apartir do seu nome, descricao e fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
	public String exibeProduto(String produto, String descricao, String fornecedor) {
		return this.sistemaFornecedores.imprimeProduto(produto, descricao, fornecedor);
	}
	
	/**
	 * Exibe todos produtos de um fornecedor.
	 * @param fornecedor nome do fornecedor.
	 * @return uma String com todos produtos do fornecedor em ordem alfabetica, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return this.sistemaFornecedores.listaProdutosDeFornecedor(fornecedor);
	}
	
	/**
	 * Exibe todos produtos ja adicionados em ordem alfabetica do seu fornecedor.
	 * @return uma String com todos produtos em ordem alfabetica, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
	public String exibeProdutos() {
		return this.sistemaFornecedores.listaTodosProdutos();
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
		return this.sistemaFornecedores.editaProduto(fornecedor, produto, descricao, novoPreco);
	}
	
	/**
	 * Edita o preco de um combo apartir do seu nome, descricao, nome do fornecedor e seu novo preco.
	 * @param produto nome do combo.
	 * @param descricao descricao do combo.
	 * @param fornecedor nome do fornecedor do combo.
	 * @param novoPreco novo preco do combo.
	 * @return um booleano True se o combo for editado com sucesso.
	 */
	public boolean editaCombo(String produto, String descricao, String fornecedor, double novoFator) {
		return this.sistemaFornecedores.editaCombo(fornecedor, produto, descricao, novoFator);
	}
	
	/**
	 * Adiciona uma nova compra do cliente na conta de um fornecedor.
	 * @param cpf cpf do cliente.
	 * @param fornecedor nome do fornecedor.
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @return um booleano True se a adicao da compra for um sucesso.
	 */
	public boolean adicionaCompra(String cpf, String fornecedor, String data, String produto, String descricao) {
		return this.sistemaFornecedores.adicionaCompra(cpf, fornecedor, data, produto, descricao, this.sistemaClientes.verificaCliente(cpf));
	}
	
	/**
	 * Confere quanto e o debito do cliente com determinado fornecedor.
	 * @param cpf cpf do cliente.
	 * @param fornecedor nome do fornecedor.
	 * @return retorna o debito do cliente com tal fornecedor.
	 */
	public String getDebito(String cpf, String fornecedor) {
		return this.sistemaFornecedores.getDebito(cpf, fornecedor, this.sistemaClientes.verificaCliente(cpf));
	}
	
	/**
	 * Exibe a conta de um cliente com determinado fornecedor.
	 * @param cpf cpf do fornecedor.
	 * @param fornecedor nome do fornecedor.
	 * @return retorna uma String com todas compras de um cliente com determinado fornecedor.
	 */
	public String exibeContas(String cpf, String fornecedor) {
		return this.sistemaFornecedores.exibeContas(cpf, fornecedor, this.sistemaClientes.nomeCliente(cpf), this.sistemaClientes.verificaCliente(cpf));
	}
	
	/**
	 * Exibe todas compras de um cliente.
	 * @param cpf cpf do cliente.
	 * @return retorna uma String com todas as compras de um cliente em todas fornecedores.
	 */
	public String exibeContasClientes(String cpf) {
		return this.sistemaFornecedores.exibeContasClientes(cpf, this.sistemaClientes.nomeCliente(cpf), this.sistemaClientes.verificaCliente(cpf));
	}
	
	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "Testes/use_case_1.txt", "Testes/use_case_2.txt", "Testes/use_case_3.txt", "Testes/use_case_4.txt", "Testes/use_case_6.txt" };
		EasyAccept.main(args);
	}	
}

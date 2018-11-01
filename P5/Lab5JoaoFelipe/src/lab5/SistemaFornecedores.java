package lab5;

import java.util.Map;
import java.util.TreeMap;

/**
 * Sistema contralador dos fornecedores.
 * @author Joao Felipe da Silva Freitas.
 *
 */
public class SistemaFornecedores {

	private Map<String, Fornecedor> fornecedores;
	
	/**
	 * Construtor que inicializa o TreeMap onde ficam armazenados os fornecedores.
	 */
	public SistemaFornecedores() {
		this.fornecedores = new TreeMap<>();
	}
	
	/**
	 * Adiciona um novo fornecedor valido apartir do seu nome, email e telefone.
	 * @param nome nome do fornecedor.
	 * @param email email do fornecedor.
	 * @param telefone telefone do fornecedor.
	 * @return um booleano se fornecedor for cadastrado com sucesso.
	 */
	public boolean cadastrarFornecedor(String nome, String email, String telefone) {
		Fornecedor f = new Fornecedor(nome, email, telefone);
		if (this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}else {
			this.fornecedores.put(nome, f);
			return true;
		}
	}
	
	/**
	 * Exibe um fornecedor valido apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return uma string que representa o fornecedor no formato NOME - EMAIL - TELEFONE.
	 */
	public String imprimeFornecedor(String nome) {
		if(!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return this.fornecedores.get(nome).toString();
	}
	
	
	/**
	 * Exibe todos fornecedores validos.
	 * @return uma string que representa todos os fornecedores no formato NOME - EMAIL - TELEFONE | NOME - EMAIL - TELEFONE ....
	 */
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
	
	/**
	 * Remove um fornecedor apartir do seu nome.
	 * @param nome nome do fornecedor.
	 * @return retorna um booleano True se a remocao do fornecedor for um sucesso.
	 */
	public boolean removerFornecedor(String nome) {
		if(!this.fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}else {
			this.fornecedores.remove(nome);
			return true;
		}
	}
	
	/**
	 * Edita um fornecedor valido apartir do seu nome, nome do atributo a ser editado e a novo atributo.
	 * Os atributos validos sao: email e telefone.
	 * @param nome nome do fornecedor.
	 * @param atributo atributo a ser editado.
	 * @param novo novo atributo.
	 * @return retorna um booleano True se a edicao for um sucesso.
	 */
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
	
	/**
	 * Adiciona um produto valido para determinado fornecedor.
	 * 
	 * @param fornecedor fornecedor que vai ter aquele produto.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param valor preco do produto.
	 * @return um booleando True se o produto for adicionado com sucesso.
	 */
	public boolean cadastraProduto(String fornecedor, String produto, String descricao, double valor) {
		
		if(fornecedor == null || "".equals(fornecedor)){
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		else if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		Produto p = new ProdutoSimples(produto, descricao, valor);
		return this.fornecedores.get(fornecedor).cadastraProduto(p);
	}
	
	/**
	 * Remove um produto valido de um determinado fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @return retorna um booleano True se o produto for removido com sucesso.
	 */
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
	
	/**
	 * Exibe um produto apartir do seu nome, descricao e fornecedor.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @return uma String no formato PRODUTO - DESCRICAO - PRECO.
	 */
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
	
	/**
	 * Exibe todos produtos de um fornecedor.
	 * @param fornecedor nome do fornecedor.
	 * @return uma String com todos produtos do fornecedor em ordem alfabetica, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
	public String listaProdutosDeFornecedor(String fornecedor) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Fornecedor inexistente.");
		}
		return this.fornecedores.get(fornecedor).listaProdutos();
	}
	
	/**
	 * Exibe todos produtos ja adicionados em ordem alfabetica do seu fornecedor.
	 * @return uma String com todos produtos em ordem alfabetica, no formado FORNECEDOR - PRODUTO - DESCRICAO - PRECO.
	 */
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
	
	/**
	 * Edita o preco de um produto apartir do seu nome, descricao, nome do fornecedor e seu novo preco.
	 * @param produto nome do produto.
	 * @param descricao descricao do produto.
	 * @param fornecedor nome do fornecedor do produto.
	 * @param valor novo preco do produto.
	 * @return um booleano True se o produto for editado com sucesso.
	 */
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

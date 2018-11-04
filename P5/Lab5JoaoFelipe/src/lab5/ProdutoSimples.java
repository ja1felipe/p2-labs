package lab5;

/**
 * Representacao de um produto.
 * @author Joao Felipe da Silva Freitas.
 *
 */
public class ProdutoSimples implements Produto{
	private String nome;
	private String descricao;
	private double preco;
	
	/**
	 * Constroi um produto apatir do seu nome, descricao e preco.
	 * @param nome nome do produto.
	 * @param descricao descricao do produto.
	 * @param preco preco do produto.
	 */
	public ProdutoSimples(String nome, String descricao, double preco) {
		if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}else if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
		
	
	/**
	 * Seta o preco do produto.
	 * @param preco preco do produto.
	 */
	public void setPreco(double preco) {
		if(preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		this.preco = preco;
	}
	
	/**
	 * Pega o nome do produto.
	 * @return o nome do produto.
	 */
	public String getNomeProduto() {
		return this.nome+this.descricao;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString() {
		String resultado = String.format("%.2f", this.preco);
		String msg = this.nome + " - " + this.descricao + " - " + "R$" + resultado;
		return msg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoSimples other = (ProdutoSimples) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	

}

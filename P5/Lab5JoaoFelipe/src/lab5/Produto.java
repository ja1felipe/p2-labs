package lab5;

public interface Produto extends Comparable<Produto> {
	
	/**
	 * Representacao do Produto em String.
	 * @return retorna uma String que representa o Produto.
	 */
	public String toString();
	/**
	 * Pega o nome completo do produto.
	 * @return retorna o nome+descricao do produto.
	 */
	public String getNomeProduto();
	/**
	 * Pega o nome do produto.
	 * @return retorna o nome do produto.
	 */
	public String getNome();
	/**
	 * Pega o preco do produto.
	 * @return retorna o preco do produto.
	 */
	public double getPreco();
	/**
	 * Seta um novo preco/fator de desconto do Produto.
	 * @param preco novo preco ou fator de desconto do Produto.
	 */
	public void setPreco(double preco);
	/**
	 * Verifica se um Produto e igual a outro.
	 * @param obj objeto a ser comparado.
	 * @return retorna um booleando determinado se o Produto e igual ou nao ao objeto comparado.
	 */
	public boolean equals(Object obj);
	default int compareTo(Produto o) {
		return this.getNome().compareTo(o.getNome());
	}
}

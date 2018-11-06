package lab5;

/**
 * Representa um combo de produtos.
 * @author joao Felipe da Silva Freitas
 *
 */
public class ProdutoCombo implements Produto {
	private ProdutoSimples[] produtos;
	private String nome;
	private String descricao;
	private double fator;
	
	/**
	 * Constroi um novo combo apartir do seu nome, descricao, fato de desconto e um array de Produtos Simples.
	 * @param nome nome do novo combo.
	 * @param descricao descricao do novo combo.
	 * @param fator fator de desconto.
	 * @param produtos array de Produtos simples.
	 */
	public ProdutoCombo(String nome, String descricao, double fator, ProdutoSimples[] produtos) {
		this.produtos = produtos;
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
	}
	
	/**
	 * Percorre o array de Produtos Simples e vai somando seu preco e depois multiplica por (1-fator de desconto).
	 * @return
	 */
	private double fazConta() {
		double soma = 0;
		for (int i = 0; i < produtos.length; i++) {
			soma += produtos[i].getPreco();
		}
		soma = soma * (1-fator);
		return soma;
	}
	
	/**
	 * Seta um novo fator de desconto para o combo.
	 * @param fator novo fator de desconto.
	 */
	public void setPreco(double fator) {
		this.fator = fator;
	}
	
	/**
	 * Pega o preco atual do combo.
	 * @return retorna um preco do combo.
	 */
	public double getPreco() {
		return this.fazConta();
	}
	
	/**
	 * Retorna um Stirng no formato NOME+DESCRICAO
	 * @return retorna uma String.
	 */
	public String getNomeProduto() {
		return this.nome+this.descricao;
	}
	
	/**
	 * Retorna o nome do combo.
	 * @return retorna o nome do combo.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna uma representasao em String do combo.
	 * @return retorna uma String no formato NOME - DESCRICAO - R$PRECO
	 * */
	@Override
	public String toString() {
		String resultado = String.format("%.2f", this.fazConta());
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
		ProdutoCombo other = (ProdutoCombo) obj;
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

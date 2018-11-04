package lab5;

public class ProdutoCombo implements Produto {
	private ProdutoSimples[] produtos;
	private String nome;
	private String descricao;
	private double fator;
	
	public ProdutoCombo(String nome, String descricao, double fator, ProdutoSimples[] produtos) {
		this.produtos = produtos;
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
	}
	
	private double fazConta() {
		double soma = 0;
		for (int i = 0; i < produtos.length; i++) {
			soma += produtos[i].getPreco();
		}
		soma = soma * (1-fator);
		return soma;
	}
	public void setPreco(double fator) {
		this.fator = fator;
	}
	
	public double getPreco() {
		return this.fazConta();
	}
	
	public String getNomeProduto() {
		return this.nome+this.descricao;
	}
	
	public String getNome() {
		return this.nome;
	}
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

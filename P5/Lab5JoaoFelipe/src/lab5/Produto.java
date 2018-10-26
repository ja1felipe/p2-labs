package lab5;

public class Produto {
	private String nome;
	private String descricao;
	private double preco;
	
	public Produto(String nome, String descricao, double preco) {
		if(nome == null || descricao == null) {
			throw new NullPointerException("Nome ou descricao nulo");
		}else if("".equals(nome) || "".equals(descricao)) {
			throw new IllegalArgumentException("Nome ou descricao invalido");
		}
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String getNomeProduto() {
		return this.nome;
	}
	@Override
	public String toString() {
		String msg = this.nome + " - " + this.descricao + " - " + "R$" + this.preco;
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
		Produto other = (Produto) obj;
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

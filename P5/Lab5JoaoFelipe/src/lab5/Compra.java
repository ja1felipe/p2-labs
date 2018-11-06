package lab5;

/**
 * Representa uma compra.
 * @author Joao Felipe da Silva Freitas
 *
 */
public class Compra implements Comparable<Compra>{
	
	

	private String data;
	private String produto;
	private double preco;
	
	
	/**
	 * Constroi uma nova compra apatir da data, nome do produto e preco.
	 * @param data data da compra.
	 * @param produto nome do produto comprado.
	 * @param preco preco do produto.
	 */
	public Compra(String data, String produto, double preco) {
		this.data = data;
		this.produto = produto;
		this.preco = preco;
	}

	/**
	 * Pega o preco da compra.
	 * @return retorna o preco da compra.
	 */
	public double getPreco() {
		
		return this.preco;
	}
	
	/** 
	 * Retorna uma represetacao da compra em String.
	 * @return uma String no formato PRODUTO - DATA
	 */
	public String toString() {
		String dataf = this.data.replace("/", "-");
		return this.produto + " - " + dataf;
	}

	@Override
	public int compareTo(Compra o) {
		return this.toString().compareTo(o.toString());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		Compra other = (Compra) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
}

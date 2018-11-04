package lab5;

public interface Produto extends Comparable<Produto> {
	
	public String toString();
	public String getNomeProduto();
	public String getNome();
	public double getPreco();
	public void setPreco(double preco);
	public boolean equals(Object obj);
	default int compareTo(Produto o) {
		return this.getNome().compareTo(o.getNome());
	}
}

package lab5;

public class Compra implements Comparable<Compra>{
	
	private String data;
	private String produto;
	private double preco;
	
	
	public Compra(String data, String produto, double preco) {
		this.data = data;
		this.produto = produto;
		this.preco = preco;
	}

	public double getPreco() {
		
		return this.preco;
	}
	
	public String toString() {
		String dataf = this.data.replace("/", "-");
		return this.produto + " - " + dataf;
	}

	@Override
	public int compareTo(Compra o) {
		return this.toString().compareTo(o.toString());
	}
}

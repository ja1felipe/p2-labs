package lab02;

public class ContaCantina {
	private String nome;
	private int conta;
	private int items;
	private int totalValor;
	public ContaCantina(String nome){
		this.nome = nome;
	}
	public void cadastraLanche(int quantos, int valor) {
		this.conta += valor;
		this.totalValor += valor;
		this.items += quantos;
	}
	public void pagaConta(int valor) {
		this.conta -= valor;
	}
	public int getFaltaPagar() {
		return conta;
	}
	
	public String toString() {
		String msg = this.nome + " " + this.items + " " + this.totalValor;
		return msg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

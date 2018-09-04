package lab02;

public class ContaLaboratorio {
	private String nome;
	private int cota = 2000;
	private int consumo;
	
	public ContaLaboratorio(String nome) {
		this.nome = nome;
	}
	public ContaLaboratorio(String nome, int cota) {
		this.nome = nome;
		this.cota = cota;
	}
	
	public void consomeEspaco(int mbytes) {
		this.consumo += mbytes;
	}
	public void liberaEspaco(int mbytes) {
		this.consumo -= mbytes;
		if (this.consumo < 0) {
			this.consumo = 0;
		}
	}
	public boolean atingiuCota() {
		if (this.consumo < this.cota) {
			return false;
		}else {
			return true;
		}
	}
	public String toString() {
		String msg = this.nome + " " + this.consumo + "/" +this.cota; 
		return msg;
	}
	public static void main(String[] args) {

	}
}

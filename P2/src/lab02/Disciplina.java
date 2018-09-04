package lab02;

import java.util.Arrays;

public class Disciplina {
	private String nome;
	private int horas = 0;
	private double[] nota = new double[4];
	private double media;
	public Disciplina(String nome) {
		this.nome = nome;
	}
	
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}
	
	public void cadastraNota(int nota, double valorNota) {
		if(nota == 1) {
			this.nota[0] = valorNota;
		}else if(nota == 2){
			this.nota[1] = valorNota;
		}else if(nota == 3) {
			this.nota[2] = valorNota;
		}else if(nota == 4) {
			this.nota[3] = valorNota; 
		}
	}
	public boolean aprovado() {
		this.media = (this.nota[0] + this.nota[1] + this.nota[2] + this.nota[3]) / 4;
		if (this.media >= 7) {
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
		String msg = this.nome + " " + this.horas + " " + this.media + " " + Arrays.toString(nota);
		return msg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

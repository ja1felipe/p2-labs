package lab5;

import java.util.ArrayList;
import java.util.List;

public class ProdutoCombo {
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
	
	public String getNomeProduto() {
		return this.nome;
	}
	@Override
	public String toString() {
		String resultado = String.format("%.2f", this.fazConta());
		String msg = this.nome + " - " + this.descricao + " - " + "R$" + resultado;
		return msg;
	}
}

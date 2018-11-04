package lab5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Conta {
	
	private Set<Compra> compras;
	private static DecimalFormat df2 = new DecimalFormat(".00");
	
	public Conta() {
		this.compras = new HashSet<>();
	}
	
	public boolean cadastraCompra(String data, String produto, double preco) {
		Compra c = new Compra(data, produto, preco);
		this.compras.add(c);
		return true;
	}
	
	public String getDebito() {
		double soma = 0;
		for (Compra a : this.compras) {
			soma += a.getPreco();
		}
		df2.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
		return df2.format(soma);
	}
}

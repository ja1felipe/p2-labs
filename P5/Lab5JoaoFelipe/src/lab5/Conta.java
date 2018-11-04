package lab5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Conta {
	
	private List<Compra> compras;
	private static DecimalFormat df2 = new DecimalFormat(".00");
	
	public Conta() {
		this.compras = new ArrayList<>();
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
	
	public String exibeContas() {
		String msg = "";
		for (Compra a : this.compras) {
			msg += a.toString() + " | ";
		}
		return msg.substring(0, msg.length()-3);
	}
}

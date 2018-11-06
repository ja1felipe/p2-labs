package lab5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Representa uma conta.
 * @author Joao Felipe da Silva Freitas
 *
 */
public class Conta {
	
	private List<Compra> compras;
	private static DecimalFormat df2 = new DecimalFormat(".00");
	
	/**
	 * Inicializa o ArrayList de compras.
	 */
	public Conta() {
		this.compras = new ArrayList<>();
	}
	
	/**
	 * Cadastra uma compra apatir da data, nome do produto e preco.
	 * @param data data da compra.
	 * @param produto nome do produto.
	 * @param preco preco da compra.
	 * @return retorna um booleano caso a compra seja cadastrada com sucesso.
	 */
	public boolean cadastraCompra(String data, String produto, double preco) {
		Compra c = new Compra(data, produto, preco);
		this.compras.add(c);
		return true;
	}
	
	/**
	 * Retorna o debito total da conta.
	 * @return retorna o debito total da conta.
	 */
	public String getDebito() {
		double soma = 0;
		for (Compra a : this.compras) {
			soma += a.getPreco();
		}
		df2.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
		return df2.format(soma);
	}
	
	/**
	 * Mostra uma representacao da conta em String.
	 * @return retorna uma String no formato COMPRA | COMPRA | ....
	 */
	public String exibeContas() {
		String msg = "";
		for (Compra a : this.compras) {
			msg += a.toString() + " | ";
		}
		return msg.substring(0, msg.length()-3); 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
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
		Conta other = (Conta) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		return true;
	}
}

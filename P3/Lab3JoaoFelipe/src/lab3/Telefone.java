package lab3;

/**
 * Armazena o telefone da pessoa e configura-o caso tenha ddd e/ou ddi.
 * @author Joao Felipe da Silva Freitas.
 *
 */
public class Telefone {
	/**
	 *O telefone que esta sendo armazenado. 
	 */
	private String telefone;
	
	/**
	 * @param telefone numero do telefone.
	 */
	public Telefone(String telefone) {
		try {
			this.telefone = verificaPrefixo(telefone);
		}
		catch (NumberFormatException e) {
			this.telefone = "";
		}
	}
	
	/**
	 * @param numero numero a ser analisado.
	 * @return retorna o numero ja configurado com ddd e ddi ou não, depende de como o numero foi passado.
	 */
	public String verificaPrefixo(String numero) {
		if(numero.length() <= 9 && numero.length() > 0) {
			;
		}else if(numero.length() < 13 && numero.length() > 0) {
			numero = "(" + numero.charAt(0) + numero.charAt(1) + ")" + numero.substring(2, numero.length());
		}else if(numero.length() >= 13) {
			numero = "+"+numero.substring(0, 2)+"("+numero.substring(2, 4)+")"+ numero.substring(4, numero.length());
		}else {
			throw new NumberFormatException("Teste");
		}
		return numero;
	}
	/**
	 * @return retorna o numero do telefone.
	 * */
	public String toString() {
		return this.telefone;
	}

}

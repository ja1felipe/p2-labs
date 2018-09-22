package lab3;

/**
 * Representacao de um contato presente em uma agenda.
 * @author Joao Felipe da Silva Freitas
 *
 */
public class Contato {
	/**
	 * Posicao que o contato foi adicionado no array.
	 */
	private int posicao;
	/**
	 * Nome do contato.
	 */
	private String nome;
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;
	/**
	 * Array onde ficam os diferentes telefones que um contato pode ter.
	 */
	private Telefone[] telefone = new Telefone[3];
	/**
	 * Nivel de amizade do contato.
	 */
	private int afinidade;

	/**
	 * Constroi um novo contato apartir das informacoes passadas pelo usuario.
	 * @param posicao posicao do contato.
	 * @param nome nome do contato.
	 * @param sobrenome sobrenome do contato.
	 * @param celular numero de celular do contato.
	 * @param trabalho numero do trabalho do contato.
	 * @param casa numero da casa do contato.
	 * @param afinidade nivel de amizade do contato.
	 */
	public Contato(int posicao, String nome, String sobrenome, Telefone celular, Telefone trabalho, Telefone casa, int afinidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone[0] = celular;
		this.telefone[1] = trabalho;
		this.telefone[2] = casa;
		this.posicao = posicao;
		this.afinidade = afinidade;
	}
	/**
	 * @return a representacao do contato no formato POSICAO - NOME SOBRENOME.*/
	public String toString() {
		String msg = Integer.toString(this.posicao) + " - " + this.nome + " " + this.sobrenome;
		return msg;
	}
	/**
	 * @return a representacao do contato no formato NOME SOBRENOME - CELULAR ###### TRABALHO ###### CASA ######.
	 */
	public String exibir() {
		String msg = this.nome + " " + this.sobrenome + " - ";
		for (int i = 0; i < telefone.length; i++) {
			try {
				if (i == 0) {
					msg +="CELULAR: " + telefone[i].toString() + " ";
				}else if(i == 1) {
					msg +="TRABALHO: " + telefone[i].toString() + " ";
				}else {
					msg +="CASA: " + telefone[i].toString();
				}
			}
			catch (NumberFormatException e) {
				;
			}
		}
		return msg;
	}
	/**
	 * @return o nome do contato.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @return um Array com todos numeros de telefones que um contato pode ter.
	 */
	public String[] getTelefone() {
		String Telefones[] = {telefone[0].toString(), telefone[1].toString(), telefone[2].toString()};
		return Telefones;	
	}
	/**
	 * @return o nivel de amizade de um contato.
	 */
	public int getAfinidade() {
		return this.afinidade;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Contato)) {
			return false;
		}
		Contato c = (Contato) obj;
		if (this.nome.equals(c.nome) && this.sobrenome.equals(c.sobrenome)) {
			return true;
		}
		return false;
	}
}

package lab3;

import java.util.Arrays;

/**
 * Armazena e administra contatos presentes na agenda.
 * @author Joao Felipe da Silva Freitas
 *
 */
public class Agenda {
	/** 
	 * Array que contem os contatos da agenda.
	 */
	private Contato[] contatos = new Contato[100];
	/**
	 * Numero de contatos cadastrados.
	 */
	private int numCadastrados = 0;
	
	/**
	 * Exibe o contato desejado.
	 * @param posicao posicao do contato que sera exibido.
	 * @return uma String que contem as informacoes do contato.
	 */
	public String ExibirContato(int posicao) {
		
		try {
		Contato exibido = contatos[posicao-1];
		String msg = exibido.exibir();
		return msg;
		}
		catch (NullPointerException e) {
			return "NÃO EXISTE CONTATO NESSA POSIÇÃO.";
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return "POSIÇÃO ERRADA, LEMBRE OS CONTATOS VÃO DA POSIÇÃO 1 A 100 SOMENTE.";
		}
		
	}

	/**
	 * Lista todos contatos presentes na agenda.
	 * @return String com uma lista de contatos.
	 */
	public String ListaContatos() {
		boolean flag = false;
		String msg = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				msg += contatos[i].toString()+"\n";
				flag = true;
			}
		}if (!flag) {
			return "NÃO A NENHUM CONTATO CADASTRADO.";
		}
		msg = msg.substring(0, msg.length()-1);
		return msg;
	}

	/**
	 * Cadastra um novo contato na agenda.
	 * @param posicao posicao do contato.
	 * @param nome nome do contato.
	 * @param sobrenome sobrenome do contato.
	 * @param celular numero de celular do contato.
	 * @param trabalho numero do trabalho do contato.
	 * @param casa numero da casa do contato.
	 * @param afinidade nivel de amizade do contato.
	 * @return uma confirmacao se o contato foi cadastrado ou deu algum erro.
	 */
	public String CadastraContato(int posicao, String nome, String sobrenome, Telefone celular, Telefone trabalho, Telefone casa, int afinidade) {
		String msg;
		if (posicao < 101) {
			try {
				contatos[posicao-1] = (new Contato(posicao, nome, sobrenome, celular, trabalho, casa, afinidade));
				msg = "CADASTRO REALIZADO!";
				numCadastrados += 1;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				msg = "POSIÇÃO INVÁLIDA";
			}
		}else {
			msg = "POSIÇÃO INVÁLIDA";
		}
		return msg;
	}
	
	/**
	 * Exibi todos contatos com o nome que esta procurando.
	 * @param nome nome do contato que deseja exibir.
	 * @return retorna uma string com todos contatos que possuem esse nome.
	 */
	public String ExibirPorNome(String nome) {
		String msg = "";
		for (int i = 0; i < numCadastrados; i++) {
			try {
				if (contatos[i].getNome().equals(nome)) {
					msg += contatos[i].exibir()+"\n";
				}
			}
			catch (NullPointerException e) {
				;
			}
		}
		msg = msg.substring(0, msg.length()-1);
		return msg;
	}
	/**
	 * Exibi todos contatos com o numero procurado.
	 * @param numero numero do contato que deseja exibir.
	 * @return retorna uma string com todos contatos que possuem esse numero.
	 */
	public String ExibirPorNumero(String numero) {
		String msg = "";
		for (int i = 0; i < numCadastrados; i++) {
			try {
				String[] telefones = contatos[i].getTelefone();
				for (int j = 0; j < telefones.length; j++) {
					if(numero.equals(telefones[j])) {
						msg += contatos[i].exibir()+"\n";
						break;
					}	
				}
			}
			catch (NullPointerException e) {
				;
			}
		}
		msg = msg.substring(0, msg.length()-1);
		return msg;
	}
	/**
	 * Exibi todos contatos com o nivel de amizade procurado.
	 * @param afinidade nivel de amizade que esta sendo procurado.
	 * @return retorna uma string com todos contatos que possuem esse nivel de amizade.
	 */
	public String ExibirPorAfinidade(int afinidade) {
		String msg = "";
		for (int i = 0; i < contatos.length; i++) {
			try {
				if (contatos[i].getAfinidade() == afinidade) {
					msg += contatos[i].exibir()+"\n";
				}
			}
			catch (NullPointerException e) {
				;
			}
		}
		msg = msg.substring(0, msg.length()-1);
		return msg;
	}
	/**
	 * Exibi a quantidade de contatos com determinado nivel de amizade.
	 * @param afinidade nivel de amizade que esta sendo procurado.
	 * @return quantidade de contatos com esse nivel de amizade.
	 */
	public int qntAfinidade(int afinidade) {
		int resp = 0;
		for (int i = 0; i < contatos.length; i++) {
			try {
			if (contatos[i].getAfinidade() == afinidade) {
					resp += 1;
				}
			}
			catch (NullPointerException e) {
				;
			}
		}
		return resp;
	}
	
	/**
	 * Faz a media do nivel de amizade dos contatos da agenda.
	 * @return a media do nivel de amizade de todos contatos presentes na agenda.
	 */
	public double mediaAfinidade() {
		double total = 0;
		for (int i = 0; i < contatos.length; i++) {
			try {
				total += contatos[i].getAfinidade();
			}
			catch (NullPointerException e) {
				;
			}
		}
		double resultado = total / numCadastrados;
		return  resultado;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}

}

package lab4;

import java.util.HashSet;

/**
 * Representacao de um grupo de alunos.
 * @author João Felipe da Silva Freitas
 *
 */
public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos;
	
	/**
	 * Constroi um objeto grupo apartir do seu nome.
	 * @param nome - nome do grupo.
	 */
	public Grupo(String nome) {
		this.nome = nome;
		alunos = new HashSet<>();
	}
	
	/**
	 * Cadastra determinado Aluno no grupo.
	 * @param aluno - Objeto aluno que ira ser cadastrado no grupo.
	 */
	public void cadastraAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	/**
	 * Verifica se determinado aluno faz parte do grupo.
	 * @param aluno - Objeto aluno que sera verificado.
	 * @return um booleando true se o aluno esta no grupo e false se nao estiver.
	 */
	public boolean verificaAluno(Aluno aluno) {
		if(alunos.contains(aluno)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Gera uma representacao do grupo em String.
	 * @return retorna uma String.
	 * */
	public String toString() {
		String msg = "";
		if (alunos.size() > 0) {
			for (Aluno aluno : alunos) {
				msg += "* " + aluno.toString() + "\n";
			}
			msg = msg.substring(0, msg.length()-1);
			return msg;
		}else {
			return "Não há nenhum aluno neste grupo.";
		}
	}
}

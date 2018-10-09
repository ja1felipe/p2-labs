package lab4;

/**
 * Representacao de um aluno.
 * @author Jo�o Felipe da Silva Freitas.
 *
 */
public class Aluno {
	private String nome;
	private String curso;
	private int matricula;
	
	/**
	 * Construtor que constroi um aluo apartir da sua matricula, nome e curso.
	 * @param matricula - matricula do aluno.
	 * @param nome - nome do aluno.
	 * @param curso - curso do aluno.
	 */
	public Aluno(int matricula, String nome, String curso) {
		if (nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException();
		}
		if (nome == null || curso == null) {
			throw new NullPointerException();
		}
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
	}
	/**
	 * Gera uma representacao de aluno em String.
	 * @return retorna uma String.
	 * */
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	/**
	 * Gera uma representacao de aluno em int.
	 * @return retorna um int.
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
		return result;
	}
	/**
	 * Verifica se dois objetos sao iguais.
	 * @return retorna um booleano.
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
}

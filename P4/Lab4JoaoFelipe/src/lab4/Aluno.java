package lab4;

public class Aluno {
	private String nome;
	private String curso;
	private int matricula;
	
	public Aluno(int matricula, String nome, String curso) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
	}
	
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
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
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
}

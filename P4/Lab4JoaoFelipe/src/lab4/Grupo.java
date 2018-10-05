package lab4;

import java.util.HashSet;

public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos;
	
	public Grupo(String nome) {
		this.nome = nome;
		alunos = new HashSet<>();
	}
	
	public void cadastraAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public boolean verificaAluno(Aluno aluno) {
		if(alunos.contains(aluno)) {
			return true;
		}else {
			return false;
		}
	}
	public String toString() {
		String msg = "";
		for (Aluno aluno : alunos) {
			msg += "* " + aluno.toString() + "\n";
		}
		msg = msg.substring(0, msg.length()-1);
		return msg;
	}
}

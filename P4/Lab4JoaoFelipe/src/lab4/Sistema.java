package lab4;
import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {
	private HashMap <Integer, Aluno> alunos;
	private HashMap <String, Grupo> grupos;
	private ArrayList <String> respostas;
	
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respostas = new ArrayList<>();
	}
	
	public String cadastraAluno(int matricula, String nome, String curso) {
		String msg = "";
		Aluno aluno = new Aluno(matricula, nome, curso);
		if (!this.alunos.containsKey(matricula)) {
			this.alunos.put(matricula, aluno);
			msg = "Aluno cadastrado com sucesso.";
		}else {
			msg = "Aluno com esta matricula ja cadastrado.";
		}
		return msg;
	}
	
	public String consultaAluno(int matricula) {
		String msg = "";
		if (this.alunos.containsKey(matricula)) {
			msg = "Aluno: " + this.alunos.get(matricula).toString();
		}else {
			msg = "Aluno não cadastrado.";
		}
		return msg;
	}
	
	public String cadastraGrupo(String nome) {
		String msg = "";
		Grupo grupo = new Grupo(nome);
		if (!this.grupos.containsKey(nome)) {
			this.grupos.put(nome, grupo);
			msg = "Grupo cadastrado com sucesso.";
		}else {
			msg = "Grupo já existente.";
		}
		return msg;
	}
	
	public String alocaNoGrupo(int matricula, String grupo) {
		String msg = "";
		if (this.grupos.containsKey(grupo)) {
			if(this.alunos.containsKey(matricula)) {
				if(!this.grupos.get(grupo).verificaAluno(this.alunos.get(matricula))) {
					this.grupos.get(grupo).cadastraAluno(this.alunos.get(matricula));
					msg = "Aluno alocado com sucesso.";
				}else {
					msg = "Aluno já cadastrado.";
				}
			}else {
				msg = "Aluno inexistente.";
			}
		}else {
			msg = "Não existe um grupo com este nome.";
		}
		return msg;
	}
	public String imprimeGrupo(String nome) {
		String msg = "";
		if(this.grupos.containsKey(nome)) {
			msg = "Alunos do grupo "+ nome.toUpperCase() + ":\n" + this.grupos.get(nome).toString();
		}else {
			msg = "Grupo inexistente.";
		}
		return msg;
	}
	public String cadastraResposta(int matricula) {
		String msg = "";
		if (this.alunos.containsKey(matricula)) {
			this.respostas.add(this.alunos.get(matricula).toString());
			msg = "Resposta cadastrada com sucesso.";
		}else {
			msg = "Não existe aluno com essa matricula cadastrada.";
		}
		return msg;
	}
	public String imprimeRespostas() {
		String msg = "Alunos:\n";
		for (int i = 0; i < this.respostas.size(); i++) {
			msg += respostas.get(i)+"\n";
		}
		msg = msg.substring(0, msg.length()-1);
		return msg;
	}
}

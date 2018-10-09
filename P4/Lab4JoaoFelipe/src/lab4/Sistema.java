package lab4;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representacao de um sistema que controla as informacoes recebidas pelo main e sua interecao com as demais classes.
 * @author Jo�o Felipe da Silva Freitas.
 *
 */
public class Sistema {
	private HashMap <Integer, Aluno> alunos;
	private HashMap <String, Grupo> grupos;
	private ArrayList <String> respostas;
	
	/**
	 * Constroi um sistema.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.respostas = new ArrayList<>();
	}
	
	/**
	 * Cadastra um novo aluno ao sistema.
	 * @param matricula - matricula do aluno.
	 * @param nome - nome do aluno.
	 * @param curso - curso do aluno.
	 * @return uma String que confirma ou n�o se o aluno foi cadastrado.
	 */
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
	
	/**
	 * Consulta as informacoes de um determinado aluno.
	 * @param matricula - matricula do aluno.
	 * @return as informacoes do aluno que possue a matricula passada.
	 */
	public String consultaAluno(int matricula) {
		String msg = "";
		if (this.alunos.containsKey(matricula)) {
			msg = "Aluno: " + this.alunos.get(matricula).toString();
		}else {
			msg = "Aluno nao cadastrado.";
		}
		return msg;
	}
	
	/**
	 * Cadastra um novo grupo ao sistema.
	 * @param nome - nome do grupo.
	 * @return uma String confirmando ou n�o se o grupo foi cadastrado.
	 */
	public String cadastraGrupo(String nome) {
		String msg = "";
		Grupo grupo = new Grupo(nome);
		if (!this.grupos.containsKey(nome)) {
			this.grupos.put(nome, grupo);
			msg = "Grupo cadastrado com sucesso.";
		}else {
			msg = "Grupo ja existente.";
		}
		return msg;
	}
	
	/**
	 * Aloca um aluno de matricula X a um determinado grupo.
	 * @param matricula - matricula do aluno.
	 * @param grupo - nome do grupo.
	 * @return uma String confirmando ou n�o se o aluno foi alocado ao grupo.
	 */
	public String alocaNoGrupo(int matricula, String grupo) {
		String msg = "";
		if (this.grupos.containsKey(grupo)) {
			if(this.alunos.containsKey(matricula)) {
				if(!this.grupos.get(grupo).verificaAluno(this.alunos.get(matricula))) {
					this.grupos.get(grupo).cadastraAluno(this.alunos.get(matricula));
					msg = "Aluno alocado com sucesso.";
				}else {
					msg = "Aluno ja cadastrado.";
				}
			}else {
				msg = "Aluno inexistente.";
			}
		}else {
			msg = "Nao existe um grupo com este nome.";
		}
		return msg;
	}
	/**
	 * Imprime os alunos que fazem parte de um determinado grupo.
	 * @param nome - nome do grupo.
	 * @return uma String com todos alunos que fazem parte do grupo.
	 */
	public String imprimeGrupo(String nome) {
		String msg = "";
		if(this.grupos.containsKey(nome)) {
			msg = "Alunos do grupo "+ nome.toUpperCase() + ":\n" + this.grupos.get(nome).toString();
		}else {
			msg = "Grupo inexistente.";
		}
		return msg;
	}
	/**
	 * Cadastra que um aluno respondeu uma questao.
	 * @param matricula - matricula do aluno.
	 * @return uma String que confirma ou nao se o aluno foi cadastrado na lista de alunos que responderam alguma questao.
	 */
	public String cadastraResposta(int matricula) {
		String msg = "";
		if (this.alunos.containsKey(matricula)) {
			this.respostas.add(this.alunos.get(matricula).toString());
			msg = "Resposta cadastrada com sucesso.";
		}else {
			msg = "Nao existe aluno com essa matricula cadastrada.";
		}
		return msg;
	}
	/**
	 * Imprime todos alunos da lista dos que responderam.
	 * @return uma String com todos alunos que responderam alguma questao.
	 */
	public String imprimeRespostas() {
		String msg = "Alunos:\n";
		int cont = 1;
		if (this.respostas.size() > 0) {
			for (int i = 0; i < this.respostas.size(); i++) {
				msg += cont + ". " + respostas.get(i)+"\n";
				cont++;
			}
			msg = msg.substring(0, msg.length()-1);
			return msg;
		}else {
			return "Nenhum aluno respondeu ainda.";
		}
	}
}

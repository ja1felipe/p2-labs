package lab4;

public class Fachada {
	private Sistema sistema;
	
	public Fachada() {
		sistema = new Sistema();
	}
	
	public String cadastraAluno(int matricula, String nome, String curso) {
		return sistema.cadastraAluno(matricula, nome, curso);
	}
	
	public String consultaAluno(int matricula) {
		return sistema.consultaAluno(matricula);
	}
	
	public String cadastraGrupo(String nome) {
		return sistema.cadastraGrupo(nome);
	}
	
	public String alocaNoGrupo(int matricula, String grupo) {
		return sistema.alocaNoGrupo(matricula, grupo);
	}
	
	public String imprimeGrupo(String nome) {
		return sistema.imprimeGrupo(nome);
	}
	
	public String cadastraResposta(int matricula) {
		return sistema.cadastraResposta(matricula);
	}
	
	public String imprimeRespostas() {
		return sistema.imprimeRespostas();
	}
}

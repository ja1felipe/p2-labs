package lab4;
import java.util.Scanner;
public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Fachada fachada = new Fachada();
	
	public static void Menu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.print("Opcao >> ");
	}
	
	public static void cadastra() {
		System.out.print("Matricula: ");
		int matricula = Integer.parseInt(sc.nextLine());
		System.out.print("Nome do aluno: ");
		String nome = sc.nextLine();
		System.out.print("Curso: ");
		String curso = sc.nextLine();
		try {
			System.out.println(fachada.cadastraAluno(matricula, nome, curso));
		}catch (IllegalArgumentException e) {
			System.out.println(("Nome ou curso inválido, cadastro nao realizado, tente novamente."));
		}
	}
	
	public static void exibir() {
		System.out.print("Matricula: ");
		int matricula = Integer.parseInt(sc.nextLine());
		System.out.println(fachada.consultaAluno(matricula));
	}
	
	public static void cadastraGrupo() {
		System.out.print("Nome do grupo: ");
		String nome = sc.nextLine().toLowerCase();
		try {
			System.out.println(fachada.cadastraGrupo(nome));
		}catch (IllegalArgumentException e) {
			System.out.println(("Nome do curso invalido, cadastro nao realizado, tente novamente."));
		}
	}
	
	public static void alocaOuImprime() {
		System.out.println("(A)locar Aluno no Grupo");
		System.out.println("(I)mprimir Grupos");
		System.out.print("Opcao >> ");
		String choice = sc.nextLine().toUpperCase();
		if(choice.equals("A")) {
			System.out.print("Matricula: ");
			int matricula = Integer.parseInt(sc.nextLine());
			System.out.print("Nome do grupo: ");
			String grupo = sc.nextLine().toLowerCase();
			System.out.println(fachada.alocaNoGrupo(matricula, grupo));
		}
		if(choice.equals("I")) {
			System.out.print("Nome do grupo: ");
			String grupo = sc.nextLine().toLowerCase();
			System.out.println(fachada.imprimeGrupo(grupo));
		}
	}
	
	public static void cadastraResposta() {
		System.out.print("Matricula: ");
		int matricula = Integer.parseInt(sc.nextLine());
		System.out.println(fachada.cadastraResposta(matricula));
	}
	
	public static void main(String[] args) {
		while(true) {
			Menu();
			String opcao = sc.nextLine().toUpperCase();
			if(opcao.equals("C")) {
				cadastra();
			}
			else if (opcao.equals("E")) {
				exibir();
			}
			else if (opcao.equals("N")) {
				cadastraGrupo();
			}
			else if (opcao.equals("A")) {
				alocaOuImprime();
			}
			else if(opcao.equals("R")) {
				cadastraResposta();
			}
			else if(opcao.equals("I")) {
				System.out.println(fachada.imprimeRespostas());
			}
			else if(opcao.equals("O")) {
				break;
			}
			else {
				System.out.println("Opcao invalida.");
			}
		}
		
	}
}

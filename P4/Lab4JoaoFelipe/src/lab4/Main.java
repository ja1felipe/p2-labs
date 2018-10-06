package lab4;
import java.util.Scanner;
public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Sistema sistema = new Sistema();
	
	public static void Menu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		System.out.print("Opção >> ");
	}
	
	public static void main(String[] args) {
		while(true) {
			Menu();
			String opcao = sc.nextLine().toUpperCase();
			if(opcao.equals("C")) {
				System.out.print("Matrícula: ");
				int matricula = Integer.parseInt(sc.nextLine());
				System.out.print("Nome do aluno: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				if (nome.equals("") || curso.equals("")) {
					System.out.println(("Nome ou curso inválido, cadastro não realizado, tente novamente."));
				}else {
					System.out.println(sistema.cadastraAluno(matricula, nome, curso));
				}
			}
			else if (opcao.equals("E")) {
				System.out.print("Matrícula: ");
				int matricula = Integer.parseInt(sc.nextLine());
				System.out.println(sistema.consultaAluno(matricula));
			}
			else if (opcao.equals("N")) {
				System.out.print("Nome do grupo: ");
				String nome = sc.nextLine().toLowerCase();
				if (nome.equals("")) {
					System.out.println(("Nome do curso inválido, cadastro não realizado, tente novamente."));
				}else {
					System.out.println(sistema.cadastraGrupo(nome));
				}
			}
			else if (opcao.equals("A")) {
				System.out.println("(A)locar Aluno no Grupo");
				System.out.println("(I)mprimir Grupos");
				System.out.print("Opção >> ");
				String choice = sc.nextLine().toUpperCase();
				if(choice.equals("A")) {
					System.out.print("Matrícula: ");
					int matricula = Integer.parseInt(sc.nextLine());
					System.out.print("Nome do grupo: ");
					String grupo = sc.nextLine().toLowerCase();
					System.out.println(sistema.alocaNoGrupo(matricula, grupo));
				}
				if(choice.equals("I")) {
					System.out.print("Nome do grupo: ");
					String grupo = sc.nextLine().toLowerCase();
					System.out.println(sistema.imprimeGrupo(grupo));
				}
			}
			else if(opcao.equals("R")) {
				System.out.print("Matrícula: ");
				int matricula = Integer.parseInt(sc.nextLine());
				System.out.println(sistema.cadastraResposta(matricula));
			}
			else if(opcao.equals("I")) {
				System.out.println(sistema.imprimeRespostas());
			}
			else if(opcao.equals("O")) {
				break;
			}
			else {
				System.out.println("Opção inválida.");
			}
		}
		
	}
}

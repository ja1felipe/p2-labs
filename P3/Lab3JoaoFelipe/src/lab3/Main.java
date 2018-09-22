package lab3;
import java.util.Scanner;
/**
 * Interface a qual o usuario tem acesso.
 * @author Joao Felipe da Silva Freitas
 *
 */
public class Main {
	/**
	 * Scanner usado para leitura de dados da entrada.
	 */
	public static Scanner sc = new Scanner(System.in);
	/**
	 * Agenda que esta sendo gerenciada.
	 */
	private static Agenda agenda = new Agenda();
	/**
	 * Responsavel por exibir o menu.
	 */
	public static void Menu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(O)utras opções");
		System.out.println("(S)air");
		System.out.print("Opção >> ");
		
	}
	/**
	 * Interface visivel para o usuario.
	 * */
	public static void main(String[] args) {
		while (true) {
				Menu();
				String opcao = sc.nextLine();
				opcao = opcao.toUpperCase();
				if (opcao.equals("S")) {
					break;
				}
				if (opcao.equals("C")) {
					System.out.print("Posição: ");
					int posicao = Integer.parseInt(sc.nextLine());
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Sobrenome: ");
					String sobrenome = sc.nextLine();
					System.out.print("Celular: ");
					String celular = sc.nextLine().toUpperCase();
					Telefone celular1 = new Telefone(celular);
					System.out.print("Trabalho: ");
					String trabalho = sc.nextLine().toUpperCase();
					Telefone trabalho1 = new Telefone(trabalho);
					System.out.print("Casa: ");
					String casa = sc.nextLine().toUpperCase();
					Telefone casa1 = new Telefone(casa);
					System.out.print("Nível de afinidade de 1 a 5: ");
					int afinidade = Integer.parseInt(sc.nextLine());
					System.out.println(agenda.CadastraContato(posicao, nome, sobrenome, celular1, trabalho1, casa1, afinidade));
				}
				if (opcao.equals("L")) {
					agenda.ListaContatos();
				}
				if (opcao.equals("E")) {
					System.out.print("Procurar por posicao(escreva assim), nome, contato ou afinidade?: ");
					String resp = sc.nextLine().toLowerCase();
					if ("posicao".equals(resp)) {
						System.out.print("Qual posição do contato? ");
						int posicao = Integer.parseInt(sc.nextLine());
						System.out.println(agenda.ExibirContato(posicao));
					}else if("nome".equals(resp)) {
						System.out.print("Qual nome que procuras? ");
						String nome = sc.nextLine();
						agenda.ExibirPorNome(nome);
					}else if("contato".equals(resp)) {
						System.out.print("Qual numero que procuras? ");
						String numero = sc.nextLine();
						agenda.ExibirPorNumero(numero);
					}else if("afinidade".equals(resp)) {
						System.out.print("Qual afinidade que procuras? ");
						int afinidade = Integer.parseInt(sc.nextLine());
						agenda.ExibirPorAfinidade(afinidade);
				}
			}
				if (opcao.equals("O")) {
					System.out.println("(R)etornar a quantidade de contatos de um determinado tipo (nível de amizade).");
					System.out.println("(M)ostrar a média de amizade da agenda.");
					System.out.print("Opção>> ");
					String opcao2 = sc.nextLine().toUpperCase();
					if(opcao2.equals("R")) {
						System.out.print("Qual nível de amizade estas a procurar? ");
						int nivel = Integer.parseInt(sc.nextLine());
						System.out.println("Há exatamente " + agenda.qntAfinidade(nivel) + " pessoas com este nivel de amizade.");
					}else if(opcao2.equals("M")) {
						System.out.println("Média " + agenda.mediaAfinidade());
				}
			}
		}
	}
}

package lab5;

public class Main {
	private static SistemaClientes sistema = new SistemaClientes();
	public static void main(String[] args) {
		sistema.cadastrarCliente("111", "Felipe", "sda@c.com", "VTEX");
		System.out.println(sistema.imprimeCliente("111"));
		sistema.cadastrarCliente("123", "Ana", "aa@a.com", "SPLAB");
		System.out.println(sistema.imprimeTodosClientes());
		sistema.removerCliente("124");
		System.out.println(sistema.imprimeTodosClientes());
		sistema.editarCliente("111", "Claudio", "", "");
		System.out.println(sistema.imprimeCliente("111"));
	}

}

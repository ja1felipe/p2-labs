package lab5;


public class Main {

	public static void main(String[] args) {
		Facade fachada = new Facade();
		fachada.adicionaCliente("07348489354", "Felipe", "a@a.com", "SPLAB");
		fachada.adicionaFornecedor("Seu Olavo", "n@n.com", "444");
		fachada.adicionaProduto("Seu Olavo", "Carne", "Carne", 2.00);
		fachada.adicionaCompra("07348489354", "Seu Olavo", "01/01/1999", "Carne", "Carne");
	}

}

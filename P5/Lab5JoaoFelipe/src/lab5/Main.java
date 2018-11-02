package lab5;

public class Main {

	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor("Felipe", "aa.acom", "88");
		Produto a = new ProdutoSimples("Carne","Carne", 2.0);
		Produto b = new ProdutoSimples("Feijao","Feijao", 2.0);
		fornecedor.cadastraProduto(a);
		fornecedor.cadastraProduto(b);
		String[] produtosPassados = {"Carne - Carne", "Feijao - Feijao"};
		fornecedor.cadastraCombo("Arroz", "Arroz", 0.2, produtosPassados);
		System.out.println(fornecedor.imprimeProduto("Arroz", "Arroz"));
		fornecedor.editaProduto("Carne", "Carne", 5.0);
		System.out.println(fornecedor.imprimeProduto("Arroz", "Arroz"));
	}

}

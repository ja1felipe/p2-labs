package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteFornecedor {

	@Test
	void testCadastraFornecedorValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
	}
	
	
	@Test
	void testCadastraFornecedorNomeInvalido() {
		try {
			Fornecedor c = new Fornecedor("","aa@a.com","4545");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraFornecedorEmailInvalido() {
		try {
			Fornecedor c = new Fornecedor("Felipe","","4545");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraFornecedorTelefoneInvalido() {
		try {
			Fornecedor c = new Fornecedor("Felipe","aa@a.com","");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testSetEmailValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		c.setEmail("b@b.com");
	}
	
	@Test
	void testSetEmailInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		try {
			c.setEmail("");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testSetTelefoneValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		c.setTelefone("45454545");
	}
	
	@Test
	void testSetTelefoneInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		try {
			c.setTelefone("");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void cadastraProdutoValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		assertEquals(true, c.cadastraProduto(p));
	}
	
	@Test
	void cadastraProdutoInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		try {
			c.cadastraProduto(p);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: produto ja existe.", e.getMessage());
		}
		
	}
	
	@Test
	void removeProdutoValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		assertEquals(true, c.removeProduto("Arroz", "Arroz"));
	}
	
	@Test
	void removeProdutoInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		try {
			c.removeProduto("Arroz","Arroz");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro na remocao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	void exibeProdutoValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		String msg = "Arroz - Arroz - R$5,00";
		assertEquals(msg, c.imprimeProduto("Arroz", "Arroz"));
	}
	
	@Test
	void exibeProdutoInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		try {
			c.imprimeProduto("Arroz", "Arroz");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro na exibicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	void listProdutos() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		Produto p2 = new ProdutoSimples("Aarroz","Arroz",5.00);
		c.cadastraProduto(p);
		c.cadastraProduto(p2);
		String msg = "Felipe - Aarroz - Arroz - R$5,00 | Felipe - Arroz - Arroz - R$5,00";
		assertEquals(msg, c.listaProdutos());
	}
	
	@Test
	void editaProdutoValido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		assertEquals(true, c.editaProduto("Arroz", "Arroz", 4.00));
	}
	
	@Test
	void editaProdutoInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		try {
			c.editaProduto("Cuscuz", "Cuscuz", 4.00);
		} catch (IllegalAccessError e) {
			assertEquals("Erro na edicao de produto: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	void toStringFornecedor() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		String msg = "Felipe - aa@a.com - 4545";
		assertEquals(msg, c.toString());
	}
	
	@Test
	void testEqualsFornecedorTrue() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Fornecedor d = new Fornecedor("Felipe","aa@a.com","4545");
		assertEquals(true, c.equals(d));
	}
	
	@Test
	void testEqualsFornecedorTrueTrue() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");		
		assertEquals(true, c.equals(c));
	}
	
	@Test
	void testEqualsFornecedorFalse() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Fornecedor d = new Fornecedor("Alberto","aa@a.com","4545");
		assertEquals(false, c.equals(d));
	}
	
	@Test
	void testEqualsFornecedorFalseFalse() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");		
		assertEquals(false, c.equals(null));
	}
	
	@Test
	void testEqualsFornecedorFalseFalseFalse() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Object d = new Object();
		assertEquals(false, c.equals(d));
	}
	
	@Test
	void testCadastraComboTrue() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		p = new ProdutoSimples("Carne","Carne",5.00);
		c.cadastraProduto(p);
		String[] array = {"Arroz - Arroz", "Carne - Carne"};
		assertEquals(true, c.cadastraCombo("Arroz - Carne", "arroz e carne", 0.2, array));
	}
	
	@Test
	void testCadastraComboInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		p = new ProdutoSimples("Carne","Carne",5.00);
		c.cadastraProduto(p);
		String[] array = {"Arroz - Arroz", "Carne - Carne"};
		c.cadastraCombo("Arroz - Carne", "arroz e carne", 0.2, array);
		try {
			c.cadastraCombo("Arroz - Carne", "arroz e carne", 0.2, array);
		}catch (IllegalArgumentException e) {
		assertEquals("Erro no cadastro de combo: combo ja existe.", e.getMessage());
		}
	}
	

	@Test
	void testEditaComboTrue() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		p = new ProdutoSimples("Carne","Carne",5.00);
		c.cadastraProduto(p);
		String[] array = {"Arroz - Arroz", "Carne - Carne"};
		c.cadastraCombo("Arroz - Carne", "arroz e carne", 0.2, array);
		assertEquals(true, c.editaCombo("Arroz - Carne", "arroz e carne", 0.1));
	}
	
	@Test
	void testEditaComboInvalido() {
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		p = new ProdutoSimples("Carne","Carne",5.00);
		c.cadastraProduto(p);
		String[] array = {"Arroz - Arroz", "Carne - Carne"};
		try {
			c.editaCombo("Araa", "sad",0.1);
		}catch (IllegalAccessError e) {
			assertEquals("Erro na edicao de combo: produto nao existe.", e.getMessage());
		}
	}
	
	@Test
	void testAdicionaCompraTrue() {
		Cliente a = new Cliente("07348489354", "P", "aa@a.com", "SPLAB");
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		p = new ProdutoSimples("Carne","Carne",5.00);
		c.cadastraProduto(p);
		String[] array = {"Arroz - Arroz", "Carne - Carne"};
		c.cadastraCombo("Arroz - Carne", "arroz e carne", 0.2, array);
		assertEquals(true, c.adicionaCompra("07348489354", "01/12/2010", "Carne", "Carne"));
	}
	
	@Test
	void testAdicionaCompraFalse() {
		Cliente a = new Cliente("07348489354", "P", "aa@a.com", "SPLAB");
		Fornecedor c = new Fornecedor("Felipe","aa@a.com","4545");
		Produto p = new ProdutoSimples("Arroz","Arroz",5.00);
		c.cadastraProduto(p);
		p = new ProdutoSimples("Carne","Carne",5.00);
		c.cadastraProduto(p);
		String[] array = {"Arroz - Arroz", "Carne - Carne"};
		c.cadastraCombo("Arroz - Carne", "arroz e carne", 0.2, array);
		try {
			c.adicionaCompra("07348489354", "01/12/2010", "Carn", "Carne");
		} catch (IllegalAccessError e) {
			assertEquals("Erro ao cadastrar compra: produto nao existe.", e.getMessage());
		}
	}
}

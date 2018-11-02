package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProdutoSimples {

	@Test
	void testProdutoSimplesValido() {
		ProdutoSimples p = new ProdutoSimples("Arroz", "Arroz", 5.00);
	}
	
	@Test
	void testCadastraProdutoSimplesNomeInvalido() {
		try {
			ProdutoSimples c = new ProdutoSimples("","Arroz",5.00);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de ProdutoSimples: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraProdutoSimplesDescricaoInvalido() {
		try {
			ProdutoSimples c = new ProdutoSimples("Arroz","",5.00);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de ProdutoSimples: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraProdutoSimplesPrecoInvalido() {
		try {
			ProdutoSimples c = new ProdutoSimples("Arroz","Arroz",-1);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de ProdutoSimples: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	void testSetPrecoValido() {
		ProdutoSimples p = new ProdutoSimples("Arroz", "Arroz", 5.00);
		p.setPreco(2.00);
	}
	
	@Test
	void testSetPrecoInvalido() {
		ProdutoSimples p = new ProdutoSimples("Arroz", "Arroz", 5.00);
		try {
			p.setPreco(-2);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de ProdutoSimples: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	void testGetNomeProdutoSimples() {
		ProdutoSimples p = new ProdutoSimples("Arroz", "Arroz", 5.00);
		String msg ="Arroz";
		assertEquals(msg, p.getNomeProduto());
	}
	
	@Test
	void testToString() {
		ProdutoSimples p = new ProdutoSimples("Arroz", "Arroz", 5.00);
		String msg = "Arroz - Arroz - R$5,00";
		assertEquals(msg, p.toString());
	}
	
	@Test
	void testEqualsTrue(){
		ProdutoSimples c = new ProdutoSimples("Arroz", "Arroz", 5.00);
		ProdutoSimples d = new ProdutoSimples("Arroz", "Arroz", 5.00);
		assertEquals(true, c.equals(d));
	}
	
	@Test
	void testEqualsTrueTrue(){
		ProdutoSimples c = new ProdutoSimples("Arroz", "Arroz", 5.00);
		assertEquals(true, c.equals(c));
	}
	
	@Test
	void testEqualsFalse(){
		ProdutoSimples c = new ProdutoSimples("Arroz", "Arroz", 5.00);
		ProdutoSimples d = new ProdutoSimples("Aarroz", "Arroz", 5.00);
		assertEquals(false, c.equals(d));
	}
	
	@Test
	void testEqualsFalseFalse(){
		ProdutoSimples c = new ProdutoSimples("Arroz", "Arroz", 5.00);
		assertEquals(false, c.equals(null));
	}
	
	@Test
	void testEqualsFalseFalseFalse(){
		ProdutoSimples c = new ProdutoSimples("Arroz", "Arroz", 5.00);
		Object o = new Object();
		assertEquals(false, c.equals(o));
	}
}

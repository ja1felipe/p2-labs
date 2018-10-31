package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProduto {

	@Test
	void testProdutoValido() {
		Produto p = new Produto("Arroz", "Arroz", 5.00);
	}
	
	@Test
	void testCadastraProdutoNomeInvalido() {
		try {
			Produto c = new Produto("","Arroz",5.00);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraProdutoDescricaoInvalido() {
		try {
			Produto c = new Produto("Arroz","",5.00);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraProdutoPrecoInvalido() {
		try {
			Produto c = new Produto("Arroz","Arroz",-1);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	void testSetPrecoValido() {
		Produto p = new Produto("Arroz", "Arroz", 5.00);
		p.setPreco(2.00);
	}
	
	@Test
	void testSetPrecoInvalido() {
		Produto p = new Produto("Arroz", "Arroz", 5.00);
		try {
			p.setPreco(-2);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
	}
	
	@Test
	void testGetNomeProduto() {
		Produto p = new Produto("Arroz", "Arroz", 5.00);
		String msg ="Arroz";
		assertEquals(msg, p.getNomeProduto());
	}
	
	@Test
	void testToString() {
		Produto p = new Produto("Arroz", "Arroz", 5.00);
		String msg = "Arroz - Arroz - R$5,00";
		assertEquals(msg, p.toString());
	}
	
	@Test
	void testEqualsTrue(){
		Produto c = new Produto("Arroz", "Arroz", 5.00);
		Produto d = new Produto("Arroz", "Arroz", 5.00);
		assertEquals(true, c.equals(d));
	}
	
	@Test
	void testEqualsTrueTrue(){
		Produto c = new Produto("Arroz", "Arroz", 5.00);
		assertEquals(true, c.equals(c));
	}
	
	@Test
	void testEqualsFalse(){
		Produto c = new Produto("Arroz", "Arroz", 5.00);
		Produto d = new Produto("Aarroz", "Arroz", 5.00);
		assertEquals(false, c.equals(d));
	}
	
	@Test
	void testEqualsFalseFalse(){
		Produto c = new Produto("Arroz", "Arroz", 5.00);
		assertEquals(false, c.equals(null));
	}
	
	@Test
	void testEqualsFalseFalseFalse(){
		Produto c = new Produto("Arroz", "Arroz", 5.00);
		Object o = new Object();
		assertEquals(false, c.equals(o));
	}
}

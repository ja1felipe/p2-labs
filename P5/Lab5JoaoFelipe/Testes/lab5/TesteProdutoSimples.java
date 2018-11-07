package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProdutoSimples {

	@Test
	void testSetGetPreco() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		s.setPreco(2.0);
		assertEquals(2.0, s.getPreco());
	}
	
	@Test
	void testSetPrecoInvalido() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		try {
			s.setPreco(-1);
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro de produto: preco invalido.", e.getMessage());
		}
		
	}
	
	@Test
	void testGetNome() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		assertEquals("Carne", s.getNome());
	}
	
	@Test
	void testGetNomeDescricao() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		assertEquals("CarneCarne", s.getNomeProduto());
	}
	
	@Test
	void testToString() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		String msg = "Carne - Carne - R$5,00";
		assertEquals(msg, s.toString());
	}
	
	@Test
	void testEqualsProdutoTrue() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		ProdutoSimples d = new ProdutoSimples("Carne", "Carne", 5.0);
		assertEquals(true, s.equals(d));
	}
	
	@Test
	void testEqualsProdutoTrueTrue() {
		ProdutoSimples c = new ProdutoSimples("Carne", "Carne", 5.0);	
		assertEquals(true, c.equals(c));
	}
	
	@Test
	void testEqualsProdutoFalse() {
		ProdutoSimples s = new ProdutoSimples("Carne", "Carne", 5.0);
		ProdutoSimples d = new ProdutoSimples("Arroz", "Carne", 5.0);
		assertEquals(false, s.equals(d));
	}
	
	@Test
	void testEqualsProdutoFalseFalse() {
		ProdutoSimples c = new ProdutoSimples("Carne", "Carne", 5.0);	
		assertEquals(false, c.equals(null));
	}
	
	@Test
	void testEqualsProdutoFalseFalseFalse() {
		ProdutoSimples c = new ProdutoSimples("Carne", "Carne", 5.0);
		Object d = new Object();
		assertEquals(false, c.equals(d));
	}
}

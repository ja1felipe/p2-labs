package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteProdutoCombo {
	
	@Test
	void testGetPrecoNormal() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		assertEquals(8.0, p.getPreco());
	}
	
	@Test
	void testGetPrecoDiferenciado() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		p.setPreco(0.1);
		assertEquals(9.0, p.getPreco());
	}
	
	@Test
	void testGetNome() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		String msg = "Carne arrozcarne e arroz";
		assertEquals(msg, p.getNomeProduto());
	}
	
	@Test
	void testGetNomeSoNome() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		String msg = "Carne arroz";
		assertEquals(msg, p.getNome());
	}
	
	@Test
	void testToString() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		String msg = "Carne arroz - carne e arroz - R$8,00";
		assertEquals(msg, p.toString());
	}
	
	@Test
	void testEqualsComboTrue() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		ProdutoCombo g = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		assertEquals(true, p.equals(g));
	}
	
	@Test
	void testEqualsComboTrueTrue() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);	
		assertEquals(true, p.equals(p));
	}
	
	@Test
	void testEqualsComboFalse() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);
		ProdutoCombo g = new ProdutoCombo("Carne", "carne e arroz", 0.2, array);
		assertEquals(false, p.equals(g));
	}
	
	@Test
	void testEqualsComboFalseFalse() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);	
		assertEquals(false, p.equals(null));
	}
	
	@Test
	void testEqualsComboFalseFalseFalse() {
		ProdutoSimples f = new ProdutoSimples("Arroz","Arroz",5.00);
		ProdutoSimples d = new ProdutoSimples("Carne","Carne",5.00);
		ProdutoSimples[] array = {f, d};
		ProdutoCombo p = new ProdutoCombo("Carne arroz", "carne e arroz", 0.2, array);	
		Object g = new Object();
		assertEquals(false, p.equals(g));
	}
}

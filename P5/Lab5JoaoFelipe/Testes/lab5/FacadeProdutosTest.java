package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacadeProdutosTest {
	
private Facade facade;
	
	@BeforeEach
	void setup() {
		this.facade = new Facade();
		this.facade.cadastrarFornecedor("Fatima", "f@f.com", "5");
	}
	
	@Test
	void testCadastraProdutoTrue() {
		assertEquals(true, this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5));
	}
	
	@Test
	void testCadastraProdutoFalse() {
		this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5);
		assertEquals(false, this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5));
	}
	
	@Test
	void testCadastraProdutoInvalido() {
		try {
			this.facade.cadastraProduto("Luiz", "Arroz", "Arroz", 3.5);
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testRemoverProdutoTrue() {
		this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5);
		assertEquals(true, this.facade.removerProduto("Fatima", "Arroz"));
	}
	
	@Test
	void testRemoverProdutoFalse() {
		assertEquals(false, this.facade.removerProduto("Fatima", "Arroz"));
	}
	
	@Test
	void testRemoverProdutoInvalido() {
		try {
			this.facade.removerProduto("Luiz", "Arroz");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testImprimirProdutoTrue() {
		this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5);
		String msg = "Arroz - Arroz - R$3.5";
		assertEquals(msg, this.facade.imprimeProduto("Fatima", "Arroz"));
	}
	
	@Test
	void testImprimirProdutoFalse() {
		try {
			this.facade.imprimeProduto("Luiz", "Arroz");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testImprimirProdutoInvalido() {
		try {
			this.facade.imprimeProduto("Fatima", "Carne");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testListaProdutosDeFornecedorTrue() {
		this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5);
		this.facade.cadastraProduto("Fatima", "Carne", "Carne", 2.5);
		String msg = "Fatima - Arroz - Arroz - R$3.5 | Fatima - Carne - Carne - R$2.5";
		assertEquals(msg, this.facade.listaProdutosDeFornecedor("Fatima"));
	}
	
	@Test
	void testListaProdutosDeFornecedorFalse() {
		try {
			this.facade.listaProdutosDeFornecedor("Luiz");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testListaTodosProdutosTrue() {
		this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5);
		this.facade.cadastraProduto("Fatima", "Carne", "Carne", 2.5);
		this.facade.cadastrarFornecedor("Ana", "aa@a.com", "87");
		this.facade.cadastraProduto("Ana", "Arroz", "Arroz", 3.5);
		this.facade.cadastraProduto("Ana", "Carne", "Carne", 2.5);
		String msg = "Ana - Arroz - Arroz - R$3.5 | Ana - Carne - Carne - R$2.5 | Fatima - Arroz - Arroz - R$3.5 | Fatima - Carne - Carne - R$2.5";
		assertEquals(msg, this.facade.listaTodosProdutos());
	}
	
	@Test
	void testListaTodosProdutosFalse() {
		try {
			this.facade.listaTodosProdutos();
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	void testEditaProdutoTrue() {
		this.facade.cadastraProduto("Fatima", "Arroz", "Arroz", 3.5);
		assertEquals(true, this.facade.editaProduto("Fatima", "Arroz", 4.5));
	}
	
	@Test
	void testEditaProdutoFalse() {
		assertEquals(false, this.facade.editaProduto("Fatima", "Refrigerante", 4.5));
	}
}

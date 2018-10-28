package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacadeFornecedoresTest {
	
	private Facade facade;
	
	@BeforeEach
	void setup() {
		this.facade = new Facade();
	}
	
	@Test
	void testCadastraFornecedorTrue() {
		assertEquals(true, this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587"));
	}
	
	@Test
	void testCadastraFornecedorFalse() {
		this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587");
		assertEquals(false, this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587"));
	}
	
	@Test
	void testRemoverFornecedorTrue() {
		this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587");
		assertEquals(true, this.facade.removerFornecedor("Fatima"));
	}
	
	@Test
	void testRemoverFornecedorFalse() {
		assertEquals(false, this.facade.removerFornecedor("Fatima"));
	}
	
	@Test
	void testImprimeFornecedorTrue() {
		this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587");
		String msg = "Fatima - ff@f.com - 8587";
		assertEquals(msg, this.facade.imprimeFornecedor("Fatima"));
	}
	
	@Test
	void testImprimeFornecedorFalse() {
		try {
			this.facade.imprimeFornecedor("Fatima");
		}catch (IllegalArgumentException e) {
			
		}	
	}
	
	@Test
	void testImprimeTodosFornecedoresTrue() {
		this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587");
		this.facade.cadastrarFornecedor("Ana", "ff@f.com", "8587");
		String msg = "Ana - ff@f.com - 8587 | Fatima - ff@f.com - 8587";
		assertEquals(msg, this.facade.imprimeFornecedores());
	}
	
	@Test
	void testImprimeTodosFornecedoresFalse() {
		try {
			this.facade.imprimeFornecedores();
		}catch (NullPointerException e) {
		}
	}
	
	@Test
	void testEditarFornecedorTrue() {
		this.facade.cadastrarFornecedor("Fatima", "ff@f.com", "8587");
		assertEquals(true, this.facade.editarFornecedor("Fatima", "cc@f.com", "857"));
	}
	
	@Test
	void testEditarFornecedorFalse() {
		assertEquals(false, this.facade.editarFornecedor("Fatima", "cc@f.com", "857"));
	}
}

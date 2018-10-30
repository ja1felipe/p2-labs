package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacadeClientesTest {
	
	private Facade facade;
	
	@BeforeEach
	void setup() {
		this.facade = new Facade();
	}
	
	@Test
	void testCadastraClienteTrue() {
		assertEquals(true, this.facade.adicionaCliente("111", "Felipe", "cc@cc.com", "SPLAB"));
	}
	
	@Test
	void testCadastraClienteFalse() {
		this.facade.adicionaCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		assertEquals(false, this.facade.adicionaCliente("111", "Felipe", "cc@cc.com", "SPLAB"));
	}
	
	@Test
	void testRemoveClienteTrue() {
		this.facade.adicionaCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		assertEquals(true, this.facade.removeCliente("111"));
	}
	
	@Test
	void testRemoveClienteFalse() {
		assertEquals(false, this.facade.removeCliente("111"));
	}
	
	@Test
	void testImprimeClienteTrue() {
		this.facade.adicionaCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		String msg = "Felipe - SPLAB - cc@cc.com";
		assertEquals(msg, this.facade.exibeCliente("111"));
	}
	
	@Test
	void testImprimeClienteFalse() {
		try {
			this.facade.exibeCliente("111");
		}catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testImprimeTodosClientesTrue() {
		this.facade.adicionaCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		this.facade.adicionaCliente("112", "Ana", "cc@cc.com", "VTEX");
		String msg = "Ana - VTEX - cc@cc.com | Felipe - SPLAB - cc@cc.com";
		assertEquals(msg, this.facade.exibeClientes());
	}
	
	@Test
	void testImprimeTodosClientesFalse() {
		try {
			this.facade.exibeClientes();
		}catch (NullPointerException e) {
		}
	}
	
}

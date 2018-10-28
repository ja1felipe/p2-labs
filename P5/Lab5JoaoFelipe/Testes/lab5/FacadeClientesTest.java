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
		assertEquals(true, this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB"));
	}
	
	@Test
	void testCadastraClienteFalse() {
		this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		assertEquals(false, this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB"));
	}
	
	@Test
	void testRemoveClienteTrue() {
		this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		assertEquals(true, this.facade.removerCliente("111"));
	}
	
	@Test
	void testRemoveClienteFalse() {
		assertEquals(false, this.facade.removerCliente("111"));
	}
	
	@Test
	void testImprimeClienteTrue() {
		this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		String msg = "Felipe - SPLAB - cc@cc.com";
		assertEquals(msg, this.facade.imprimeCliente("111"));
	}
	
	@Test
	void testImprimeClienteFalse() {
		try {
			this.facade.imprimeCliente("111");
		}catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testImprimeTodosClientesTrue() {
		this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		this.facade.cadastrarCliente("112", "Ana", "cc@cc.com", "VTEX");
		String msg = "Ana - VTEX - cc@cc.com | Felipe - SPLAB - cc@cc.com";
		assertEquals(msg, this.facade.imprimeTodosClientes());
	}
	
	@Test
	void testImprimeTodosClientesFalse() {
		try {
			this.facade.imprimeTodosClientes();
		}catch (NullPointerException e) {
		}
	}
	
	@Test
	void testEditarClientesTrue() {
		this.facade.cadastrarCliente("111", "Felipe", "cc@cc.com", "SPLAB");
		assertEquals(true, this.facade.editarCliente("111", "Carlos", "dd@cc.com", "LCD"));
	}
	
	@Test
	void testEditarClientesFalse() {
		assertEquals(false, this.facade.editarCliente("111", "Carlos", "", ""));
	}
}

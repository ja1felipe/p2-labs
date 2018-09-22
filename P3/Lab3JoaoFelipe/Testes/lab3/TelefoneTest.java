package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTest {
	private Telefone telefone;
	@BeforeEach
	public void setup() {
		//TODO
	}
	@Test
	void testVerificaPrefixoVazio() {
		this.telefone = new Telefone("997779891");
		String msg = "997779891";
		assertEquals(this.telefone.toString(), msg);
	}
	@Test
	void testVerificaPrefixoDDD() {
		this.telefone = new Telefone("88997779891");
		String msg = "(88)997779891";
		assertEquals(this.telefone.toString(), msg);
	}
	
	@Test
	void testVerificaPrefixoDDI() {
		this.telefone = new Telefone("5588997779891111");
		String msg = "+55(88)997779891111";
		assertEquals(this.telefone.toString(), msg);
	}
	
	@Test
	void testVerificaPrefixoLimp() {
		this.telefone = new Telefone("");
		assertEquals(this.telefone.toString(), "");
}
}

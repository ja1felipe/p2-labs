package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCliente {
	
	@Test
	void testCadastraClienteValido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
	}
	
	@Test
	void testCadastraClienteCPFinvalido() {
		try {
			Cliente c = new Cliente("1234567891","Felipe","A@a.com","SPS");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: cpf invalido.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraClienteNomeInvalido() {
		try {
			Cliente c = new Cliente("1234567891","","A@a.com","SPS");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraClienteEmailInvalido() {
		try {
			Cliente c = new Cliente("1234567891","Felipe","","SPS");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testCadastraClienteLocalInvalido() {
		try {
			Cliente c = new Cliente("1234567891","Felipe","A@a.com","");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	void testSetNomeValido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		c.setNome("Carlos");
	}
	
	@Test
	void testSetNomeInvalido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		try {
			c.setNome("");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testSetEmailValido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		c.setEmail("b@b.com");
	}
	
	@Test
	void testSetEmailInvalido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		try {
			c.setEmail("");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", e.getMessage());
		}
	}
	
	@Test
	void testSetLocalValido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		c.setLocal("SPLAB");
	}
	
	@Test
	void testSetLocalInvalido() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		try {
			c.setLocal("");
		}catch (IllegalArgumentException e) {
			assertEquals("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", e.getMessage());
		}
	}
	
	@Test
	void testToString() {
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		String msg = "Felipe - SPS - A@a.com";
		assertEquals(msg, c.toString());
	}
	
	@Test
	void testEqualsTrue(){
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		Cliente d = new Cliente("12345678911","Felipe","A@a.com","SPS");
		assertEquals(true, c.equals(d));
	}
	
	@Test
	void testEqualsTrueTrue(){
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		assertEquals(true, c.equals(c));
	}
	
	@Test
	void testEqualsFalse(){
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		Cliente d = new Cliente("12345678912","Felipe","A@a.com","SPS");
		assertEquals(false, c.equals(d));
	}
	
	@Test
	void testEqualsFalseFalse(){
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		assertEquals(false, c.equals(null));
	}
	
	@Test
	void testEqualsFalseFalseFalse(){
		Cliente c = new Cliente("12345678911","Felipe","A@a.com","SPS");
		Object o = new Object();
		assertEquals(false, c.equals(o));
	}
}

package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	private Contato contato;
	private Contato contato2;
	private Contato contato3;
	private Telefone telefone;
	private Telefone telefone2;
	private Telefone telefone3;
	@BeforeEach
	public void setup() {
		telefone = new Telefone("997779891");
		telefone2 = new Telefone("88997779891");
		telefone3 = new Telefone("5588997779891");
		contato = new Contato(1, "Felipe", "Silva", telefone, telefone2, telefone3, 2);
		contato2 = new Contato(1, "Felipe", "Silva", telefone, telefone2, telefone3, 2);
		contato3 = new Contato(1, "Felipe", "Silvaa", telefone, telefone2, telefone3, 2);
	}
	@Test
	void testExibir() {
		String msg = "Felipe Silva - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891";		
		assertEquals(msg, contato.exibir());
	}
	@Test
	void testToString() {
		String msg = "1 - Felipe Silva";
		assertEquals(msg, contato.toString());
	}
	@Test
	void testgetNome() {
		String msg = "Felipe";
		assertEquals(msg, contato.getNome());
	}
	@Test
	void testgetTelefone() {
		String[] telefones = {"997779891","(88)997779891","+55(88)997779891"};
		assertArrayEquals(telefones, contato.getTelefone());
	}
	@Test
	void testgetAfinidade() {
		int msg = 2;
		assertEquals(msg, contato.getAfinidade());
	}
	@Test
	void testEqualstrue() {
		assertEquals(true, contato.equals(contato2));
	}
	@Test
	void testEqualsfalse() {
		assertEquals(false, contato.equals(contato3));
	}
}

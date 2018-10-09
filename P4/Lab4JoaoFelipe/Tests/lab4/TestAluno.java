package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAluno {

	@Test
	void testAluno() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		String msg = "2 - Felipe - CC";
		assertEquals(msg, a.toString());
	}

	@Test
	void testEqualsTrue() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		Aluno b = new Aluno(2, "Pedro", "CC");
		assertEquals(true, a.equals(b));
	}
	@Test
	void testEqualsIdenticos() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		assertEquals(true, a.equals(a));
	}
	@Test
	void testEqualsNull() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		assertEquals(false, a.equals(null));
	}
	@Test
	void testEqualsDiferentClass() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		String msg = "";
		assertEquals(false, a.equals(msg));
	}
	@Test
	void testEqualsFalse() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		Aluno b = new Aluno(3, "Pedro", "CC");
		assertEquals(false, a.equals(b));
	}
	@Test
	void testHashCode() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		assertEquals(33, a.hashCode());
	}

}

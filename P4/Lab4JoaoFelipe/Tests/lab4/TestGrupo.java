package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
	
class TestGrupo {
	private Grupo grupo;
	@BeforeEach
	public void setup() {
		grupo = new Grupo("teste");
	}
	@Test
	void testGrupo() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		this.grupo.cadastraAluno(a);
		String msg = "* 2 - Felipe - CC";
		assertEquals(msg, this.grupo.toString());
	}

	@Test
	void testVerificaAlunoTrue() {
		Aluno a = new Aluno(2, "Felipe", "CC");
		this.grupo.cadastraAluno(a);
		assertEquals(true, grupo.verificaAluno(a));
	}
	@Test
	void testVerificaAlunoFalse() {
		Aluno b = new Aluno(2, "Felipe", "CC");
		assertEquals(false, grupo.verificaAluno(b));
	}

}

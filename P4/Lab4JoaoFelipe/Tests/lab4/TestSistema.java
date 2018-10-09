package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSistema {
	private Sistema sistema;
	@BeforeEach
	public void setup() {
		sistema = new Sistema();
	}
	@Test
	void testCadastraAlunoValido() {
		String msg = "Aluno cadastrado com sucesso.";
		assertEquals(msg, sistema.cadastraAluno(2, "A", "EE"));
	}
	@Test
	void testCadastraAlunoExistente() {
		sistema.cadastraAluno(2, "A", "EE");
		String msg = "Aluno com esta matricula ja cadastrado.";
		assertEquals(msg, sistema.cadastraAluno(2, "A", "EE"));
	}

	@Test
	void testConsultaAlunoCadastrado() {
		sistema.cadastraAluno(1, "F", "CC");
		String msg = "Aluno: 1 - F - CC";
		assertEquals(msg, sistema.consultaAluno(1));
	}
	@Test
	void testConsultaAlunoInvalido() {
		String msg = "Aluno nao cadastrado.";
		assertEquals(msg, sistema.consultaAluno(2));
	}

	@Test
	void testCadastraGrupoValido() {
		String msg = "Grupo cadastrado com sucesso.";
		assertEquals(msg, sistema.cadastraGrupo("teste"));
	}
	@Test
	void testCadastraGrupoInvalido() {
		String msg = "Grupo ja existente.";
		sistema.cadastraGrupo("teste");
		assertEquals(msg, sistema.cadastraGrupo("teste"));
	}

	@Test
	void testAlocaNoGrupoValido() {
		sistema.cadastraGrupo("teste");
		sistema.cadastraAluno(1, "F", "CC");
		String msg = "Aluno alocado com sucesso.";
		assertEquals(msg, sistema.alocaNoGrupo(1, "teste"));
	}
	
	@Test
	void testAlocaNoGrupoAlunoJaCadastrado() {
		sistema.cadastraGrupo("teste");
		sistema.cadastraAluno(1, "F", "CC");
		sistema.alocaNoGrupo(1, "teste");
		String msg = "Aluno ja cadastrado.";
		assertEquals(msg, sistema.alocaNoGrupo(1, "teste"));
	}
	
	@Test
	void testAlocaNoGrupoAlunoInexistente() {
		sistema.cadastraGrupo("teste");
		String msg = "Aluno inexistente.";
		assertEquals(msg, sistema.alocaNoGrupo(1, "teste"));
	}

	@Test
	void testAlocaNoGrupoInexistente() {
		sistema.cadastraAluno(1, "F", "CC");
		String msg = "Nao existe um grupo com este nome.";
		assertEquals(msg, sistema.alocaNoGrupo(1, "teste"));
	}
	
	@Test
	void testImprimeGrupoExistente() {
		sistema.cadastraGrupo("teste");
		sistema.cadastraAluno(1, "F", "CC");
		sistema.cadastraAluno(2, "A", "CC");
		sistema.alocaNoGrupo(1, "teste");
		sistema.alocaNoGrupo(2, "teste");
		String msg = "Alunos do grupo TESTE:\n* 1 - F - CC\n* 2 - A - CC";
		assertEquals(msg, sistema.imprimeGrupo("teste"));
	}
	
	@Test
	void testImprimeGrupoInvalido() {
		String msg = "Grupo inexistente.";
		assertEquals(msg, sistema.imprimeGrupo("A"));
	}
	
	@Test
	void testImprimeGrupoVazio() {
		String msg = "Alunos do grupo A:\nNao ha nenhum aluno neste grupo.";
		sistema.cadastraGrupo("A");
		assertEquals(msg, sistema.imprimeGrupo("A"));
	}
	
	@Test
	void testCadastraRespostaValida() {
		sistema.cadastraAluno(1, "F", "CC");
		String msg = "Resposta cadastrada com sucesso.";
		assertEquals(msg, sistema.cadastraResposta(1));
	}

	@Test
	void testCadastraRespostaInvalida() {
		String msg = "Nao existe aluno com essa matricula cadastrada.";
		assertEquals(msg, sistema.cadastraResposta(1));
	}
	
	@Test
	void testImprimeRespostas() {
		sistema.cadastraAluno(1, "F", "CC");
		sistema.cadastraResposta(1);
		sistema.cadastraAluno(2, "F", "CC");
		sistema.cadastraResposta(2);
		String msg = "Alunos:\n1. 1 - F - CC\n2. 2 - F - CC";
		assertEquals(msg, sistema.imprimeRespostas());
	}
	@Test
	void testImprimeRespostasVazias() {
		String msg = "Nenhum aluno respondeu ainda.";
		assertEquals(msg, sistema.imprimeRespostas());
	}

}

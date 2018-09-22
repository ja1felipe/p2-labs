package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	private Agenda agenda;
	private Telefone telefone;
	private Telefone telefone2;
	private Telefone telefone3;
	@BeforeEach
	public void criaAgenda() {
		telefone = new Telefone("997779891");
		telefone2 = new Telefone("88997779891");
		telefone3 = new Telefone("5588997779891");
		agenda = new Agenda();
	}
	@Test
	void testCadastraSucesso() {
		String msg = "CADASTRO REALIZADO!";
		assertEquals(msg, agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2));
		
	}
	@Test
	void testCadastraInvalido() {
		String msg = "POSIÇÃO INVÁLIDA";
		assertEquals(msg, agenda.CadastraContato(101, "Felipe", "S", telefone, telefone2, telefone3, 2));
		
	}
	@Test
	void testExibirPosicao() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		String msg = "Felipe S - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891";
		assertEquals(msg, agenda.ExibirContato(1));
	}
	@Test
	void testExibirPosicaoSemContato() {
		String msg = "NÃO EXISTE CONTATO NESSA POSIÇÃO.";
		assertEquals(msg, agenda.ExibirContato(2));
	}
	@Test
	void testExibirPosicaoInvalida() {
		String msg = "POSIÇÃO ERRADA, LEMBRE OS CONTATOS VÃO DA POSIÇÃO 1 A 100 SOMENTE.";
		assertEquals(msg, agenda.ExibirContato(101));
	}
	@Test
	void testExibirNome() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 2);
		String msg = "Felipe S - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891\nFelipe S - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891";
		assertEquals(msg, agenda.ExibirPorNome("Felipe"));
	}
	@Test
	void testExibirNumero() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 2);
		String msg = "Felipe S - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891\nFelipe S - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891";
		assertEquals(msg, agenda.ExibirPorNumero("997779891"));
	}
	@Test
	void testExibirAfinidade() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 1);
		String msg = "Felipe S - CELULAR: 997779891 TRABALHO: (88)997779891 CASA: +55(88)997779891";
		assertEquals(msg, agenda.ExibirPorAfinidade(2));
	}
	@Test
	void testqntAfinidadeZero() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 2);
		int msg = 0;
		assertEquals(msg, agenda.qntAfinidade(1));
	}
	@Test
	void testqntAfinidade() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 2);
		int msg = 2;
		assertEquals(msg, agenda.qntAfinidade(2));
	}
	@Test
	void testmediaAfinidade() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 3);
		double msg = 2.5;
		assertEquals(msg, agenda.mediaAfinidade());
	}
	@Test
	void testLista() {
		agenda.CadastraContato(1, "Felipe", "S", telefone, telefone2, telefone3, 2);
		agenda.CadastraContato(2, "Felipe", "S", telefone, telefone2, telefone3, 1);
		String msg = "1 - Felipe S\n2 - Felipe S";
		assertEquals(msg, agenda.ListaContatos());
	}
	@Test
	void testListaVazio() {
		String msg = "NÃO A NENHUM CONTATO CADASTRADO.";
		assertEquals(msg, agenda.ListaContatos());
	}
}

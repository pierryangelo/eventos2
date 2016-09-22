package codes.wise.eventos.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.atividade.TipoDeAtividade;
import codes.wise.eventos.modelo.cupom.CupomPorAtividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.StatusDoEvento;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

public class CupomPorAtividadeTest {
	private Evento evento = new EventoBuilder()
			.comNome("Novo Evento")
			.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
			.getEvento();
	private CupomPorAtividade cupomPorAtividade1, cupomPorAtividade2;
	private Atividade atividade1, atividade2;
	
	@Before
	public void inicializa() throws
		JaExisteAtividadeAdicionadaException,
		HorarioJaOcupadoPorOutraAtividadeException, StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException {
		atividade1 = new AtividadeBuilder()
				.comNome("Palestra")
				.comValor(new BigDecimal("100"))
				.doEvento(evento)
				.deTipo(TipoDeAtividade.PALESTRA)
				.getAtividade();
		atividade2 = new AtividadeBuilder()
				.comNome("Minicurso")
				.comValor(new BigDecimal("100"))
				.deTipo(TipoDeAtividade.MINICURSO)
				.getAtividade();
		cupomPorAtividade1 = new CupomPorAtividade(new BigDecimal("0.10"), evento, atividade1);
		cupomPorAtividade2 = new CupomPorAtividade(new BigDecimal("0.10"), evento, atividade2);
		evento.adicionaAtividade(atividade1);
	}
	
	@Test
	public void naoEfetuaDescontoEmAtividadesQueNaoPertencemAoEventoAssociado() {
		assertEquals(false, cupomPorAtividade2.isAtivo());
	}
	
	@Test
	public void descontaValor() {
		assertEquals(new BigDecimal("10.00"), BigDecimalUtil.paraMonetario(cupomPorAtividade1
				.getPorcentagemDoDesconto()
				.multiply(atividade1.getValor())));
	}

}

package codes.wise.eventos.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.atividade.TipoDeAtividade;
import codes.wise.eventos.modelo.cupom.CupomPorAtividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.StatusDoEvento;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

public class CupomPorAtividadeTest {
	private Evento evento = new EventoBuilder()
			.comNome("Novo Evento")
			.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
			.comInicio(LocalDateTime.of(2016, 8, 1, 0, 0))
			.comTermino(LocalDateTime.of(2016, 12, 1, 0, 0))
			.getEvento();
	private CupomPorAtividade cupomPorAtividade1, cupomPorAtividade2;
	private Atividade atividade1, atividade2;
	
	@Before
	public void inicializa() throws
		JaExisteAtividadeAdicionadaException,
		HorarioJaOcupadoPorOutraAtividadeException, StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException,
		HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		atividade1 = new AtividadeBuilder()
				.comNome("Palestra")
				.comValor(new BigDecimal("100"))
				.doEvento(evento)
				.comInicio(LocalDateTime.of(2016, 8, 2, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 8, 0, 0))
				.deTipo(TipoDeAtividade.PALESTRA)
				.getAtividade();
		atividade2 = new AtividadeBuilder()
				.comNome("Minicurso")
				.comInicio(LocalDateTime.of(2016, 8, 9, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 10, 0, 0))
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

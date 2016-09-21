package codes.wise.eventos.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.cupom.CupomPorCodigo;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;

public class CupomPorCodigoTest {
	private CupomPorCodigo cupomPorCodigo1, cupomPorCodigo2;
	
	@Before
	public void inicializa() throws
		JaExisteAtividadeAdicionadaException,
		HorarioJaOcupadoPorOutraAtividadeException {
		
		cupomPorCodigo1 = new CupomPorCodigo(new BigDecimal("0.10"), "SUPER_PROMOCAO", true);
		cupomPorCodigo2 = new CupomPorCodigo(new BigDecimal("0.10"), "LITORAL_10", false);
	}
	
	@Test
	public void deveRetornarPorcentagemPassadaPeloConstrutor() {
		assertEquals(new BigDecimal("0.10"), cupomPorCodigo1.getPorcentagemDoDesconto());
	}
	
	@Test
	public void aoPassarBooleanoPeloConstrutorMetodoisAtivoDeveCorresponder() {
		assertEquals(false, cupomPorCodigo2.isAtivo());
	}
	
	
}

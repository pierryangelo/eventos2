package codes.wise.eventos.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.cupom.CupomPorData;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;

public class CupomPorDataTest {
private CupomPorData cupomPorData1, cupomPorData2;
	
	@Before
	public void inicializa() throws
		JaExisteAtividadeAdicionadaException,
		HorarioJaOcupadoPorOutraAtividadeException {
		
		cupomPorData1 = new CupomPorData(new BigDecimal("0.10"), 
				LocalDateTime.of(2016, 9, 10, 0, 0), LocalDateTime.of(2017, 10, 10, 0, 0));
		cupomPorData2 = new CupomPorData(new BigDecimal("0.10"),
				LocalDateTime.of(2016, 9, 20, 0, 0), LocalDateTime.of(2016, 9, 21, 8, 0));
	}
	
	@Test
	public void cupomAtivoSomenteNoPeriodoDeterminado() {
		assertEquals(false, cupomPorData2.isAtivo());
		assertEquals(true, cupomPorData1.isAtivo());
	}
}

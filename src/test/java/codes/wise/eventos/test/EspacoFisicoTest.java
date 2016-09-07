package codes.wise.eventos.test;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.excecoes.EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException;
import codes.wise.eventos.excecoes.EspacosFisicosComLocalizacoesIguaisException;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;

public class EspacoFisicoTest {
	private EspacoFisico e1, e2;
	
	@Before
	public void inicializa() {
		e1 = new EspacoFisico();
		e2 = new EspacoFisico();
	}
	
	@Test(expected=EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException.class)
	public void espacoFisicoNaoAceitaEspacoFisicoPaiComoEspacoFilho() 
			throws EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException, EspacosFisicosComLocalizacoesIguaisException {
		e2.setEspacoFisicoPai(e1);
		e2.adicionaEspacoFisico(e1);
	}
}

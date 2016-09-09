package codes.wise.eventos.test;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.excecoes.EventoSateliteJaAdicionadoException;
import codes.wise.eventos.excecoes.EventoSateliteNaoPodeSerEventoPaiException;
import codes.wise.eventos.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.evento.Evento;

public class EventoTest {
	private Evento e1, e2;
	private Atividade a1, a2;
	private EspacoFisico ep1, ep2;
	
	@Before
	public void inicializa() {
		e1 = new Evento();
		e2 = new Evento();
		a1 = new Atividade();
		a2 = new Atividade();
		ep1 = new EspacoFisico();
		ep2 = new EspacoFisico();
	}
	
	@Test(expected=JaExisteAtividadeAdicionadaException.class)
	public void naoAceitaAtividadesRepetidas() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException {
		a1.setId(1);
		a2.setId(1);
		e1.adicionaAtividade(a1, ep1);
		e1.adicionaAtividade(a2, ep2);
	}
	
	@Test(expected=EventoSateliteJaAdicionadoException.class)
	public void naoAceitaEventosSatelitesRepetidos() 
			throws EventoSateliteJaAdicionadoException, EventoSateliteNaoPodeSerEventoPaiException {
		e1.adicionaEventoSatelite(e2);
		e1.adicionaEventoSatelite(e2);
	}
	
	@Test(expected=EventoSateliteNaoPodeSerEventoPaiException.class)
	public void eventoSateliteNaoPodeSerEventoPai() 
			throws EventoSateliteJaAdicionadoException, EventoSateliteNaoPodeSerEventoPaiException {
		e1.adicionaEventoSatelite(e1);
	}
	
}

package codes.wise.eventos.test;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.javadocmd.simplelatlng.LatLng;

import codes.wise.eventos.excecoes.EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException;
import codes.wise.eventos.excecoes.EspacosFisicosComLocalizacoesIguaisException;
import codes.wise.eventos.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.modelo.atividade.Atividade;
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
	
	@Test(expected=HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException.class)
	public void espacoFisicoNaoPodeConterAtividadesComHorariosConflitantes() 
			throws HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException {
		Atividade a1 = new Atividade();
		Atividade a2 = new Atividade();
		a1.setDataEHoraDeInicio(LocalDateTime.of(2016, 10, 1, 8, 00));
		a1.setDataEHoraDeTermino(LocalDateTime.of(2016, 10, 1, 10, 00));
		a2.setDataEHoraDeInicio(LocalDateTime.of(2016, 10, 1, 9, 00));
		a2.setDataEHoraDeTermino(LocalDateTime.of(2016, 10, 1, 11, 00));
		e1.adicionaAtividade(a1);
		e1.adicionaAtividade(a2);
	}
	
	@Test(expected=EspacosFisicosComLocalizacoesIguaisException.class) 
	public void espacoFisicoNaoPodeConterEspacoFisicoComMesmaLocalizacao() 
			throws EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException, EspacosFisicosComLocalizacoesIguaisException {
		e1.setLocalizacao(new LatLng(30, 30));
		e2.setLocalizacao(new LatLng(30, 30));
		e1.adicionaEspacoFisico(e2);
	}
}

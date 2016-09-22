package codes.wise.eventos.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.StatusDoEvento;
import codes.wise.eventos.modelo.evento.TipoDeEvento;
import codes.wise.eventos.modelo.excecoes.EventoSateliteJaAdicionadoException;
import codes.wise.eventos.modelo.excecoes.EventoSateliteNaoPodeSerEventoPaiException;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.InscricaoJaExisteException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteFazerCheckinException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteMaisInscricoesException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaFezCheckinException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.Pessoa;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;
import codes.wise.eventos.modelo.usuario.UsuarioBuilder;

public class EventoTest {
	private Evento e1, e2, evento;
	private Atividade a1, a2, atividade;
	private Inscricao inscricao;
	private Pessoa pessoa;
	private Participacao participacao;
	
	@Before
	public void inicializa() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioJaOcupadoPorOutraAtividadeException, StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException {
		e1 = new Evento();
		e1.setStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO);
		e2 = new Evento();
		e2.setStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO);
		a1 = new Atividade();
		a2 = new Atividade();

		evento = new EventoBuilder()
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.comNome("Semana Cultural")
				.deTipo(TipoDeEvento.SEMANA_CULTURAL)
				.comInicio(LocalDateTime.now())
				.getEvento();

		atividade = new AtividadeBuilder()
				.comInicio(LocalDateTime.now())
				.comNome("Curso de Inglês")
				.comValor(new BigDecimal("200"))
				.doEvento(evento)
				.isPaga(true)
				.getAtividade();
		
		evento.adicionaAtividade(atividade);
		
		pessoa = new Pessoa();
		pessoa.setNome("Pierry Ângelo Pereira");
		participacao = new Participacao(TipoDeParticipante.ESTUDANTE, 
				new UsuarioBuilder()
				.infoPessoais(pessoa)
				.ativo(true)
				.comEmail("pierryangelo@gmail.com")
				.getUsuario());
		inscricao = new Inscricao(evento, participacao);				
	}
	
	@Test(expected=JaExisteAtividadeAdicionadaException.class)
	public void naoAceitaAtividadesRepetidas() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException, 
			HorarioJaOcupadoPorOutraAtividadeException, StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException {
		a1.setId(1);
		a2.setId(1);
		e1.adicionaAtividade(a1);
		e1.adicionaAtividade(a2);
	}
	
	@Test(expected=EventoSateliteJaAdicionadoException.class)
	public void naoAceitaEventosSatelitesRepetidos() 
			throws EventoSateliteJaAdicionadoException, 
			EventoSateliteNaoPodeSerEventoPaiException {
		evento.adicionaEventoSatelite(e2);
		evento.adicionaEventoSatelite(e2);
	}
	
	@Test(expected=EventoSateliteNaoPodeSerEventoPaiException.class)
	public void eventoSateliteNaoPodeSerEventoPai() 
			throws EventoSateliteJaAdicionadoException, 
			EventoSateliteNaoPodeSerEventoPaiException {
		e1.adicionaEventoSatelite(e1);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteMaisInscricoesException.class)
	public void naoAceitaInscricoesSeOStatusDoEventoForEM_ANDAMENTO() 
			throws InscricaoJaExisteException, 
			StatusDoEventoNaoPermiteMaisInscricoesException {
		evento.setStatus(StatusDoEvento.EM_ANDAMENTO);
		evento.adicionarInscricao(inscricao);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteMaisInscricoesException.class)
	public void naoAceitaInscricoesSeOStatusDoEventoForENCERRADO() 
			throws InscricaoJaExisteException, 
			StatusDoEventoNaoPermiteMaisInscricoesException {
		evento.setStatus(StatusDoEvento.ENCERRADO);
		evento.adicionarInscricao(inscricao);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException.class)
	public void naoAceitaAdicaoDeNovasAtividadesSeOStatusDoEventoForEM_ANDAMENTO() 
			throws JaExisteAtividadeAdicionadaException,
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException {
		evento.setStatus(StatusDoEvento.EM_ANDAMENTO);
		evento.adicionaAtividade(atividade);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException.class)
	public void naoAceitaAdicaoDeNovasAtividadesSeOStatusDoEventoForENCERRADO() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException {
		evento.setStatus(StatusDoEvento.ENCERRADO);
		evento.adicionaAtividade(atividade);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteFazerCheckinException.class)
	public void naoFazCheckinSeOStatusForEM_ANDAMENTO() 
			throws UsuarioJaFezCheckinException, 
			StatusDoEventoNaoPermiteFazerCheckinException {
		Usuario usuario = new Usuario();
		evento.setStatus(StatusDoEvento.EM_ANDAMENTO);
		evento.fazerCheckin(usuario);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteFazerCheckinException.class)
	public void naoFazCheckinSeOStatusForENCERRADO() 
			throws UsuarioJaFezCheckinException, 
			StatusDoEventoNaoPermiteFazerCheckinException {
		Usuario usuario = new Usuario();
		evento.setStatus(StatusDoEvento.ENCERRADO);
		evento.fazerCheckin(usuario);
	}
}

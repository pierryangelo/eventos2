package codes.wise.eventos.test;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException;
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
import codes.wise.eventos.modelo.usuario.PessoaBuilder;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;
import codes.wise.eventos.modelo.usuario.UsuarioBuilder;

public class EventoTest {
	private Evento evento2, evento3, evento1;
	private Atividade atividade1, atividade2, atividade0;
	private Inscricao inscricao;
	private Pessoa pessoa;
	private Participacao participacao;
	
	@Before
	public void inicializa() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException,
			HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		
		evento1 = new EventoBuilder()
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.comNome("Semana Cultural")
				.deTipo(TipoDeEvento.SEMANA_CULTURAL)
				.comInicio(LocalDateTime.of(2016, 8, 1, 0, 0))
				.comTermino(LocalDateTime.of(2016, 12, 1, 0, 0))
				.getEvento();
		
		evento2 = new EventoBuilder()
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.comNome("Semana do IFPI")
				.comInicio(LocalDateTime.of(2016, 8, 1, 0, 0))
				.comTermino(LocalDateTime.of(2016, 12, 1, 0, 0))
				.deTipo(TipoDeEvento.SEMANA_CULTURAL)
				.getEvento();
		
		evento3 = new EventoBuilder()
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.comNome("Simpósio de Novas Tecnologias")
				.comInicio(LocalDateTime.of(2016, 8, 1, 0, 0))
				.comTermino(LocalDateTime.of(2016, 12, 1, 0, 0))
				.deTipo(TipoDeEvento.SIMPOSIO)
				.getEvento();
		
		atividade0 = new AtividadeBuilder()
				.comInicio(LocalDateTime.of(2016, 8, 2, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 8, 0, 0))
				.comNome("Curso de Inglês")
				.comValor(new BigDecimal("200"))
				.doEvento(evento1)
				.isPaga(true)
				.getAtividade();
		
		atividade1 = new AtividadeBuilder()
				.comInicio(LocalDateTime.of(2016, 8, 10, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 11, 0, 0))
				.comNome("Curso de Inglês")
				.comValor(new BigDecimal("200"))
				.doEvento(evento1)
				.isPaga(true)
				.getAtividade();
		
		atividade2 = new AtividadeBuilder()
				.comInicio(LocalDateTime.of(2016, 8, 12, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 13, 0, 0))
				.comNome("Curso de Inglês")
				.comValor(new BigDecimal("200"))
				.doEvento(evento1)
				.isPaga(true)
				.getAtividade();

		evento1.adicionaAtividade(atividade0);
		
		pessoa = new PessoaBuilder()
				.comNome("Pierry Ângelo Pereira")
				.comDataDeNascimento(LocalDate.of(1988, 4, 18))
				.getPessoa();
		
		participacao = new Participacao(TipoDeParticipante.ESTUDANTE, 
				new UsuarioBuilder()
				.infoPessoais(pessoa)
				.ativo(true)
				.comEmail("pierryangelo@gmail.com")
				.getUsuario());
		
		inscricao = new Inscricao(evento1, participacao);				
	}
	
	@Test(expected=JaExisteAtividadeAdicionadaException.class)
	public void naoAceitaAtividadesRepetidas() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException, 
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException,
			HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		atividade1.setId(1);
		atividade2.setId(1);
		evento2.adicionaAtividade(atividade1);
		evento2.adicionaAtividade(atividade2);
	}
	
	@Test(expected=EventoSateliteJaAdicionadoException.class)
	public void naoAceitaEventosSatelitesRepetidos() 
			throws EventoSateliteJaAdicionadoException, 
			EventoSateliteNaoPodeSerEventoPaiException {
		evento1.adicionaEventoSatelite(evento3);
		evento1.adicionaEventoSatelite(evento3);
	}
	
	@Test(expected=EventoSateliteNaoPodeSerEventoPaiException.class)
	public void eventoSateliteNaoPodeSerEventoPai() 
			throws EventoSateliteJaAdicionadoException, 
			EventoSateliteNaoPodeSerEventoPaiException {
		evento2.adicionaEventoSatelite(evento2);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteMaisInscricoesException.class)
	public void naoAceitaInscricoesSeOStatusDoEventoForEM_ANDAMENTO() 
			throws InscricaoJaExisteException, 
			StatusDoEventoNaoPermiteMaisInscricoesException {
		evento1.setStatus(StatusDoEvento.EM_ANDAMENTO);
		evento1.adicionarInscricao(inscricao);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteMaisInscricoesException.class)
	public void naoAceitaInscricoesSeOStatusDoEventoForENCERRADO() 
			throws InscricaoJaExisteException, 
			StatusDoEventoNaoPermiteMaisInscricoesException {
		evento1.setStatus(StatusDoEvento.ENCERRADO);
		evento1.adicionarInscricao(inscricao);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException.class)
	public void naoAceitaAdicaoDeNovasAtividadesSeOStatusDoEventoForEM_ANDAMENTO() 
			throws JaExisteAtividadeAdicionadaException,
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException, HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		evento1.setStatus(StatusDoEvento.EM_ANDAMENTO);
		evento1.adicionaAtividade(atividade0);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException.class)
	public void naoAceitaAdicaoDeNovasAtividadesSeOStatusDoEventoForENCERRADO() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException, HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		evento1.setStatus(StatusDoEvento.ENCERRADO);
		evento1.adicionaAtividade(atividade0);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteFazerCheckinException.class)
	public void naoFazCheckinSeOStatusForEM_ANDAMENTO() 
			throws UsuarioJaFezCheckinException, 
			StatusDoEventoNaoPermiteFazerCheckinException {
		Usuario usuario = new Usuario();
		evento1.setStatus(StatusDoEvento.EM_ANDAMENTO);
		evento1.fazerCheckin(usuario);
	}
	
	@Test(expected=StatusDoEventoNaoPermiteFazerCheckinException.class)
	public void naoFazCheckinSeOStatusForENCERRADO() 
			throws UsuarioJaFezCheckinException, 
			StatusDoEventoNaoPermiteFazerCheckinException {
		Usuario usuario = new Usuario();
		evento1.setStatus(StatusDoEvento.ENCERRADO);
		evento1.fazerCheckin(usuario);
	}
	
	@Test(expected=HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException.class)
	public void naoPermiteAdicionarAtividadesComHorarioForaDoIntervaloDoEvento() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioJaOcupadoPorOutraAtividadeException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException, 
			HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		evento1.setInicio(LocalDateTime.of(2016, 1, 2, 0, 0));
		evento1.setTermino(LocalDateTime.of(2016, 1, 4, 0, 0));
		atividade1.setInicio(LocalDateTime.of(2016, 1, 1, 0, 0));
		atividade1.setTermino(LocalDateTime.of(2016, 1, 3, 0, 0));
		evento1.adicionaAtividade(atividade1);
	}
	
	
}

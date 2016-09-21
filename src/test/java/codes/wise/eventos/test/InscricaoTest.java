package codes.wise.eventos.test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.TipoDeEvento;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.Pessoa;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;
import codes.wise.eventos.modelo.usuario.UsuarioBuilder;

public class InscricaoTest {
	private Participacao participacao;
	private Inscricao inscricao;
	private Pessoa pessoa;
	private Usuario usuario;
	private Evento evento;
	private Atividade atividade;
	
	@Before
	public void inicializa() 
			throws JaExisteAtividadeAdicionadaException, HorarioJaOcupadoPorOutraAtividadeException {
		evento = new EventoBuilder()
				.comNome("Semana Cultural")
				.deTipo(TipoDeEvento.SEMANA_CULTURAL)
				.comInicio(LocalDateTime.now())
				.getEvento();

		atividade = new AtividadeBuilder()
				.comInicio(LocalDateTime.now())
				.comNome("Curso de Inglês")
				.comValor(new BigDecimal("200"))
				.doEvento(evento)
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
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

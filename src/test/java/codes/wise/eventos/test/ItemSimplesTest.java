package codes.wise.eventos.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.StatusDoEvento;
import codes.wise.eventos.modelo.excecoes.AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.inscricao.ItemSimples;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;

public class ItemSimplesTest {
	private ItemSimples is1;
	private Atividade atividade1, atividade2;
	private Inscricao inscricao;
	private Evento evento;

	@Before
	public void inicializa() throws 
	NaoExisteAtividadeNaListaDeAtividadesDoEventoException, 
	AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException, 
	JaExisteAtividadeAdicionadaException, 
	HorarioJaOcupadoPorOutraAtividadeException, StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException {
		this.atividade1 = new AtividadeBuilder()
				.comValor(new BigDecimal("100"))
				.isPaga(true)
				.getAtividade();
		
		this.atividade2 = new AtividadeBuilder()
				.comValor(new BigDecimal("200"))
				.isPaga(true)
				.getAtividade();

		this.evento = new EventoBuilder()
				.comNome("Evento")
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.getEvento();
				
		this.evento.adicionaAtividade(atividade1);
		this.evento.adicionaAtividade(atividade2);
		this.inscricao = new Inscricao(evento, new Participacao(TipoDeParticipante.PROFISSIONAL, new Usuario()));
		this.is1 = new ItemSimples(atividade1, inscricao);
	}
	@Test
	public void itemDeveTerMesmoValorDaAtividade() {
		assertEquals(is1.getPreco(), this.atividade1.getValor());
	}
	
	@Test(expected=AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException.class)
	public void naoAceitaAtividadeNaoPaga() throws AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException,
	NaoExisteAtividadeNaListaDeAtividadesDoEventoException {
		this.atividade1.setIsPaga(false);
		this.is1.setAtividade(atividade1);
	}
	
	@Test
	public void deveTerMesmoNomeDaAtividade() {
		assertEquals(is1.getDescricao(), this.atividade1.getNome());
	}
	
	@Test
	public void naoAceitaAtividadeQueNaoSejaDoEventoDaInscricao() 
			throws AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException, NaoExisteAtividadeNaListaDeAtividadesDoEventoException {
		this.is1.setAtividade(atividade2);
	}
}

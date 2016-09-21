package codes.wise.eventos.test;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.cupom.CupomPorAtividade;
import codes.wise.eventos.modelo.cupom.CupomPorCodigo;
import codes.wise.eventos.modelo.cupom.CupomPorData;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.excecoes.AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.inscricao.ItemSimples;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;

public class CuponsTest {
	private Evento evento;
	private Inscricao inscricao;
	private Participacao participacao;
	private Atividade atividade1, atividade2;
	private ItemSimples item1, item2;
	private CupomPorAtividade cupomAtividade;
	private CupomPorCodigo cupomPorCodigo;
	private CupomPorData cupomPorData;
	
	@Before
	public void inicializa() throws JaExisteAtividadeAdicionadaException, 
		HorarioJaOcupadoPorOutraAtividadeException,
		NaoExisteAtividadeNaListaDeAtividadesDoEventoException,
		AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException {
		this.atividade1 = new AtividadeBuilder()
				.comValor(new BigDecimal("100"))
				.isPaga(true)
				.getAtividade();
		
		this.atividade2 = new AtividadeBuilder()
				.comValor(new BigDecimal("200"))
				.isPaga(true)
				.getAtividade();

		this.evento = new EventoBuilder().comNome("Evento").getEvento();
		this.evento.adicionaAtividade(atividade1);
		this.evento.adicionaAtividade(atividade2);
		this.inscricao = new Inscricao(evento, new Participacao(TipoDeParticipante.PROFISSIONAL, new Usuario()));
		item1 = new ItemSimples(atividade1, inscricao);
		
		CupomPorCodigo cupomPorCodigo = new CupomPorCodigo(new BigDecimal("0.10"), "PROMOCAO", true);
		CupomPorAtividade cupomPorAtividade = new CupomPorAtividade(new BigDecimal("0.10"), evento, atividade1);
		CupomPorData cupomPorData = new CupomPorData(new BigDecimal("0.20"), 
				LocalDateTime.now(), LocalDateTime.of(2016, 10, 1, 0, 0));
		
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

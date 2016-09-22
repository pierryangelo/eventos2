package codes.wise.eventos.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.StatusDoEvento;
import codes.wise.eventos.modelo.excecoes.AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException;
import codes.wise.eventos.modelo.excecoes.DescontoDoItemCompostoNaoPodeSerNegativoException;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.ItemSimplesJaExisteNaListaDeItensCompostos;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException;
import codes.wise.eventos.modelo.excecoes.ValorDoItemCompostoNaoPodeSerNegativoException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.inscricao.ItemComposto;
import codes.wise.eventos.modelo.inscricao.ItemSimples;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;

public class ItemCompostoTest {

	private ItemComposto ic;
	private ItemSimples is1, is2;
	private Atividade atividade1, atividade2;
	private Inscricao inscricao;
	private Evento evento;

	@Before
	public void inicializa() throws 
	NaoExisteAtividadeNaListaDeAtividadesDoEventoException, 
	AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException, 
	JaExisteAtividadeAdicionadaException, 
	HorarioJaOcupadoPorOutraAtividadeException, 
	ItemSimplesJaExisteNaListaDeItensCompostos, 
	StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException, 
	HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException {
		this.atividade1 = new AtividadeBuilder()
				.comValor(new BigDecimal("100"))
				.isPaga(true)
				.comInicio(LocalDateTime.of(2016, 8, 2, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 8, 0, 0))
				.getAtividade();
		
		this.atividade2 = new AtividadeBuilder()
				.comValor(new BigDecimal("200"))
				.isPaga(true)
				.comInicio(LocalDateTime.of(2016, 8, 9, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 10, 0, 0))
				.getAtividade();

		this.evento = new EventoBuilder()
				.comNome("Evento")
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.comInicio(LocalDateTime.of(2016, 8, 1, 0, 0))
				.comTermino(LocalDateTime.of(2016, 12, 1, 0, 0))
				.getEvento();
		
		this.evento.adicionaAtividade(atividade1);
		this.evento.adicionaAtividade(atividade2);
		this.inscricao = new Inscricao(evento, new Participacao(TipoDeParticipante.PROFISSIONAL, new Usuario()));
		this.is1 = new ItemSimples(atividade1, inscricao);
		this.is2 = new ItemSimples(atividade2, inscricao);

	}
	@Test
	public void seNaoForPassadoDescontoOPrecoTotalDeveSerASomaDosItensSimples()
			throws ItemSimplesJaExisteNaListaDeItensCompostos, DescontoDoItemCompostoNaoPodeSerNegativoException {
		ic = new ItemComposto("Kit de Produtos", new BigDecimal("0.0"));
		ic.adicionarItem(is1);
		ic.adicionarItem(is2);
		
		assertEquals(new BigDecimal("300.00"), ic.getPreco());
	}
	
	@Test(expected=DescontoDoItemCompostoNaoPodeSerNegativoException.class)
	public void descontoNaoPodeSerNegativo() throws DescontoDoItemCompostoNaoPodeSerNegativoException, ItemSimplesJaExisteNaListaDeItensCompostos {
		ic = new ItemComposto("Novo Kit", new BigDecimal("-0.5"));
		ic.adicionarItem(is1);
		ic.adicionarItem(is2);
	}
	
	@Test(expected=ValorDoItemCompostoNaoPodeSerNegativoException.class)
	public void naoAceitaValorNegativoComoValorDoItemComposto() 
			throws ItemSimplesJaExisteNaListaDeItensCompostos, 
			DescontoDoItemCompostoNaoPodeSerNegativoException, 
			ValorDoItemCompostoNaoPodeSerNegativoException {
		ic = new ItemComposto(new BigDecimal("-100.00"), "Novo Kit");
		ic.adicionarItem(is1);
		ic.adicionarItem(is2);
	}
}

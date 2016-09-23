package codes.wise.eventos.test;

import static org.junit.Assert.*;

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
import codes.wise.eventos.modelo.evento.StatusDoEvento;
import codes.wise.eventos.modelo.evento.TipoDeEvento;
import codes.wise.eventos.modelo.excecoes.AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException;
import codes.wise.eventos.modelo.excecoes.CupomJaExisteNaListaDeCuponsException;
import codes.wise.eventos.modelo.excecoes.DescontoDoItemCompostoNaoPodeSerNegativoException;
import codes.wise.eventos.modelo.excecoes.EventoNaoContemCupomException;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.ItemJaAdicionadoAoCarrinhoException;
import codes.wise.eventos.modelo.excecoes.ItemSimplesJaExisteEmUmItemCompostoException;
import codes.wise.eventos.modelo.excecoes.ItemSimplesJaExisteNaListaDeItensCompostos;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.JaExisteUmCupomComEsteCodigoException;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.inscricao.ItemComposto;
import codes.wise.eventos.modelo.inscricao.ItemSimples;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.Pessoa;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.UsuarioBuilder;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

public class InscricaoTest {
	private Participacao participacao;
	private Inscricao inscricao;
	private Pessoa pessoa;
	private Evento evento;
	private Atividade atividade1, atividade2, atividade3;
	private ItemSimples itemSimples1, itemSimples2, itemSimples3;
	private ItemComposto itemComposto;
	
	@Before
	public void inicializa() 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioJaOcupadoPorOutraAtividadeException, 
			NaoExisteAtividadeNaListaDeAtividadesDoEventoException, 
			AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException, 
			StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException, 
			HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException, 
			DescontoDoItemCompostoNaoPodeSerNegativoException {
		evento = new EventoBuilder()
				.comStatus(StatusDoEvento.ABERTO_PARA_INSCRICAO)
				.comNome("Semana Cultural")
				.deTipo(TipoDeEvento.SEMANA_CULTURAL)
				.comInicio(LocalDateTime.of(2016, 8, 1, 0, 0))
				.comTermino(LocalDateTime.of(2016, 12, 1, 0, 0))
				.getEvento();

		atividade1 = new AtividadeBuilder()
				.comInicio(LocalDateTime.now())
				.comNome("Curso de Inglês")
				.comValor(new BigDecimal("200"))
				.comInicio(LocalDateTime.of(2016, 8, 9, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 10, 0, 0))
				.doEvento(evento)
				.isPaga(true)
				.getAtividade();
		
		atividade2 = new AtividadeBuilder()
				.comInicio(LocalDateTime.now())
				.comNome("Curso de Swift")
				.comValor(new BigDecimal("200"))
				.comInicio(LocalDateTime.of(2016, 8, 9, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 10, 0, 0))
				.doEvento(evento)
				.isPaga(true)
				.getAtividade();
		
		atividade3 = new AtividadeBuilder()
				.comInicio(LocalDateTime.now())
				.comNome("Curso de JPA")
				.comValor(new BigDecimal("200"))
				.comInicio(LocalDateTime.of(2016, 8, 9, 0, 0))
				.comTermino(LocalDateTime.of(2016, 8, 10, 0, 0))
				.doEvento(evento)
				.isPaga(true)
				.getAtividade();
		
		evento.adicionaAtividade(atividade1);
		evento.adicionaAtividade(atividade2);
		evento.adicionaAtividade(atividade3);
		
		pessoa = new Pessoa();
		pessoa.setNome("Pierry Ângelo Pereira");
		participacao = new Participacao(TipoDeParticipante.ESTUDANTE, 
				new UsuarioBuilder()
				.infoPessoais(pessoa)
				.ativo(true)
				.comEmail("pierryangelo@gmail.com")
				.getUsuario());
		inscricao = new Inscricao(evento, participacao);
		itemSimples1 = new ItemSimples(atividade1, inscricao);
		itemSimples2 = new ItemSimples(atividade2, inscricao);
		itemSimples3 = new ItemSimples(atividade3, inscricao);
		itemComposto = new ItemComposto("Kit de Itens", new BigDecimal("0"));
	}
	
	@Test(expected=ItemJaAdicionadoAoCarrinhoException.class)
	public void carrinhoNaoAceitaItensRepetidos() 
			throws ItemJaAdicionadoAoCarrinhoException, ItemSimplesJaExisteEmUmItemCompostoException {
		inscricao.adicionarItem(itemSimples1);
		inscricao.adicionarItem(itemSimples1);
	}
	
	@Test
	public void calculaTotalBrutoItensSimples() 
			throws ItemJaAdicionadoAoCarrinhoException, ItemSimplesJaExisteEmUmItemCompostoException {
		inscricao.adicionarItem(itemSimples1);
		inscricao.adicionarItem(itemSimples2);
		assertEquals(BigDecimalUtil.paraMonetario(new BigDecimal("400")), inscricao.getTotalBruto());
	}
	
	@Test
	public void calculaTotalBrutoDeItensCompostosQuandoValorNaoEPassadoComoParametro() 
			throws ItemSimplesJaExisteNaListaDeItensCompostos, 
			ItemJaAdicionadoAoCarrinhoException, ItemSimplesJaExisteEmUmItemCompostoException {
		itemComposto.adicionarItem(itemSimples1);
		itemComposto.adicionarItem(itemSimples2);
		inscricao.adicionarItem(itemComposto);
		assertEquals(BigDecimalUtil.paraMonetario(new BigDecimal("400")), inscricao.getTotalBruto());
	}
	
	@Test
	public void calculaTotalBrutoDeItensSimplesECompostosNaMesmaInscricao() 
			throws ItemSimplesJaExisteNaListaDeItensCompostos, 
			ItemJaAdicionadoAoCarrinhoException, ItemSimplesJaExisteEmUmItemCompostoException {
		itemComposto.adicionarItem(itemSimples1);
		itemComposto.adicionarItem(itemSimples2);
		inscricao.adicionarItem(itemComposto);
		inscricao.adicionarItem(itemSimples3);
		assertEquals(BigDecimalUtil.paraMonetario(new BigDecimal("600")), inscricao.getTotalBruto());
	}
	
	@Test(expected=ItemSimplesJaExisteEmUmItemCompostoException.class)
	public void naoAceitaItemSimplesQueJaConsteEmUmItemCompostoNoCarrinho() 
			throws ItemSimplesJaExisteNaListaDeItensCompostos, 
			ItemJaAdicionadoAoCarrinhoException, 
			ItemSimplesJaExisteEmUmItemCompostoException {
		itemComposto.adicionarItem(itemSimples1);
		itemComposto.adicionarItem(itemSimples2);
		inscricao.adicionarItem(itemComposto);
		inscricao.adicionarItem(itemSimples1);
	}
	
	@Test()
	public void naoAceitaCupomDeDescontoQueNaoEstejaCadastradoNoEvento() 
			throws CupomJaExisteNaListaDeCuponsException, 
			JaExisteUmCupomComEsteCodigoException, 
			EventoNaoContemCupomException, 
			ItemJaAdicionadoAoCarrinhoException, 
			ItemSimplesJaExisteEmUmItemCompostoException {
		CupomPorCodigo cupomPorCodigo = new CupomPorCodigo(new BigDecimal("0.10"), "VALHALA", true);
		evento.adicionaCupom(cupomPorCodigo);
		inscricao.adicionarCupom(cupomPorCodigo);
		inscricao.adicionarItem(itemSimples1);
		inscricao.adicionarItem(itemSimples2);
	}
	
	@Test
	public void calculaTotalComDescontoComCupomPorCodigo() 
			throws CupomJaExisteNaListaDeCuponsException,
			JaExisteUmCupomComEsteCodigoException, 
			EventoNaoContemCupomException, 
			ItemJaAdicionadoAoCarrinhoException, 
			ItemSimplesJaExisteEmUmItemCompostoException {
		CupomPorCodigo cupomPorCodigo = new CupomPorCodigo(new BigDecimal("0.10"), "VALHALA", true);
		evento.adicionaCupom(cupomPorCodigo);
		inscricao.adicionarCupom(cupomPorCodigo);
		inscricao.adicionarItem(itemSimples1);
		inscricao.adicionarItem(itemSimples2);
		assertEquals(BigDecimalUtil.paraMonetario(new BigDecimal("360")), inscricao.getTotalComDesconto());
	}
	
	@Test
	public void calculaTotalComDescontoComCupomPorAtividade() 
			throws EventoNaoContemCupomException, 
			CupomJaExisteNaListaDeCuponsException,
			JaExisteUmCupomComEsteCodigoException,
			ItemJaAdicionadoAoCarrinhoException, 
			ItemSimplesJaExisteEmUmItemCompostoException {
		CupomPorAtividade cupomPorAtividade = new CupomPorAtividade(new BigDecimal("0.10"), evento, atividade1);
		evento.adicionaCupom(cupomPorAtividade);
		inscricao.adicionarCupom(cupomPorAtividade);
		inscricao.adicionarItem(itemSimples1);
		inscricao.adicionarItem(itemSimples2);
		assertEquals(BigDecimalUtil.paraMonetario(new BigDecimal("360")), inscricao.getTotalComDesconto());
	}
	
	@Test
	public void calculaTotalComDescontoComCupomPorData() 
			throws EventoNaoContemCupomException, 
			CupomJaExisteNaListaDeCuponsException, 
			JaExisteUmCupomComEsteCodigoException, 
			ItemJaAdicionadoAoCarrinhoException,
			ItemSimplesJaExisteEmUmItemCompostoException {
		CupomPorData cupomPorData = new CupomPorData(new BigDecimal("0.10"), 
				LocalDateTime.of(2016, 9, 1, 0, 0), LocalDateTime.of(2016, 10, 1, 0, 0));
		evento.adicionaCupom(cupomPorData);
		inscricao.adicionarCupom(cupomPorData);
		inscricao.adicionarItem(itemSimples1);
		inscricao.adicionarItem(itemSimples2);
		assertEquals(BigDecimalUtil.paraMonetario(new BigDecimal("360")), inscricao.getTotalComDesconto());
	}
}

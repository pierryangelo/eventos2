package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.EventoNaoContemCupomException;
import codes.wise.eventos.modelo.excecoes.ItemJaAdicionadoAoCarrinhoException;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.cupom.Descontavel;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

public class Inscricao {
	private Long id;
	private List<Item> carrinho;
	private Participacao participacao;
	private List<Descontavel> cupons;
	private Evento evento;

	public Inscricao() {
		this.carrinho = Lists.newArrayList();
		this.cupons = Lists.newArrayList();
	}
	
	public void adicionarItem(Item item) 
			throws ItemJaAdicionadoAoCarrinhoException {
		if (this.carrinho.contains(item)) {
			throw new ItemJaAdicionadoAoCarrinhoException();
		}
		this.carrinho.add(item);
	}
	
	public BigDecimal getTotalBruto() {
		BigDecimal total = carrinho.stream()
                .map(Item::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		return BigDecimalUtil.paraMonetario(total);
	}
	
	public void adicionarCupom(Descontavel cupom) 
			throws EventoNaoContemCupomException {
		if (!this.evento.getDescontaveis().contains(cupom)) {
			throw new EventoNaoContemCupomException();
		}
		this.cupons.add(cupom);
	}
	
	/**
	 * Calcula o valor do desconto usando o método privado calcularDesconto, depois
	 * subtraia o TotalBruto do desconto calculado em cima desse total.
	 * @return totalComDesconto : BigDecimal
	 */
	public BigDecimal getTotalComDesconto() {
		BigDecimal porcentagemDesconto = this.calcularDesconto();
		BigDecimal totalBruto = this.getTotalBruto();
		BigDecimal totalComDesconto = totalBruto.subtract(totalBruto.multiply(porcentagemDesconto));
		return BigDecimalUtil.paraMonetario(totalComDesconto);
	}
	
	/**
	 * Calcula a soma dos descontos dos cupons e verifica se a porcentagem do desconto é superior a 100%,
	 * caso seja, retorna 1, caso contrário a porcentagem da soma dos descontos.
	 * @return desconto : BigDecimal
	 */
	private BigDecimal calcularDesconto() { 
		BigDecimal desconto = this.cupons.stream()
                .map(Descontavel::getPorcentagemDoDesconto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		if (desconto.compareTo(new BigDecimal("1")) == 0 || desconto.compareTo(new BigDecimal("1")) == 1 ) {
			return BigDecimalUtil.paraMonetario(new BigDecimal("1"));
		}
		return BigDecimalUtil.paraMonetario(desconto);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getCarrinho() {
		return ImmutableList.copyOf(carrinho);
	}

	public void setCarrinho(List<Item> carrinho) {
		this.carrinho = carrinho;
	}

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}

	public List<Descontavel> getCupons() {
		return ImmutableList.copyOf(cupons);
	}

	public void setCupons(List<Descontavel> cupons) {
		this.cupons = cupons;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
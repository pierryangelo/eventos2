package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.cupom.Cupom;
import codes.wise.eventos.modelo.cupom.Descontavel;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.CupomNaoExisteNaCestaException;
import codes.wise.eventos.modelo.excecoes.EventoNaoContemCupomException;
import codes.wise.eventos.modelo.excecoes.ItemJaAdicionadoAoCarrinhoException;
import codes.wise.eventos.modelo.excecoes.ItemNaoExisteNaCestaException;
import codes.wise.eventos.modelo.excecoes.ItemSimplesJaExisteEmUmItemCompostoException;
import codes.wise.eventos.modelo.pagamento.FormaDePagamento;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

@Entity
public class Inscricao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Evento evento;
	@OneToOne
	private Participacao participacao;
	@OneToMany
	private List<Cupom> cupons;
	@OneToMany(mappedBy="inscricao")
	private List<Item> carrinho;
	private boolean isPaga;
	private FormaDePagamento formaDePagamento;

	public Inscricao(Evento evento, Participacao participacao) {
		this.carrinho = Lists.newArrayList();
		this.cupons = Lists.newArrayList();
		this.evento = evento;
		this.participacao = participacao;
		this.participacao.setInscricao(this);
	}
	
	/**
	 * Adiciona um item ao carrinho (simples ou composto), porém não 
	 * adiciona itens simples que constarem em um item composto do carrinho.
	 * @param item
	 * @throws ItemJaAdicionadoAoCarrinhoException
	 * @throws ItemSimplesJaExisteEmUmItemCompostoException 
	 */
	public void adicionarItem(Item item) 
			throws ItemJaAdicionadoAoCarrinhoException, 
			ItemSimplesJaExisteEmUmItemCompostoException {
		for (Item i : this.carrinho) {
			if (i instanceof ItemComposto) {
				if (((ItemComposto) i).getItens().contains(item)) {
					throw new ItemSimplesJaExisteEmUmItemCompostoException();
				}
			}
		}
		if (this.carrinho.contains(item)) {
			throw new ItemJaAdicionadoAoCarrinhoException();
		}
		this.carrinho.add(item);
	}
	
	/**
	 * Método somente para demonstração, pois pagamento poderia ser qualquer
	 * interface externa.
	 * @return boolean
	 */
	public boolean pagarInscricao() {
		if (formaDePagamento.pagar(this.getTotalComDesconto())) {
			isPaga = true;
			return true;
		}
		return false;
	}
	
	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	public FormaDePagamento getFormaDePagamento() {
		return this.formaDePagamento;
	}
	
	public BigDecimal getTotalBruto() {
		BigDecimal total = carrinho.stream()
                .map(Item::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		return BigDecimalUtil.paraMonetario(total);
	}
	
	public void adicionarCupom(Cupom cupom) 
			throws EventoNaoContemCupomException {
		if (!this.evento.getDescontaveis().contains(cupom)) {
			throw new EventoNaoContemCupomException();
		}
		this.cupons.add(cupom);
	}
	
	public void removerCupom(Cupom cupom) 
			throws CupomNaoExisteNaCestaException {
		if (!this.cupons.contains(cupom)) {
			throw new CupomNaoExisteNaCestaException();
		}
		this.cupons.remove(cupom);
	}
	
	public void removerItem(Item item) 
			throws ItemNaoExisteNaCestaException {
		if (!this.carrinho.contains(item)) {
			throw new ItemNaoExisteNaCestaException();
		}
		this.carrinho.remove(item);
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
	public BigDecimal calcularDesconto() { 
		BigDecimal desconto = this.cupons.stream()
                .map(Descontavel::getPorcentagemDoDesconto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		if (desconto.compareTo(new BigDecimal("1")) == 0 || desconto.compareTo(new BigDecimal("1")) == 1 ) {
			return BigDecimalUtil.paraMonetario(new BigDecimal("1"));
		}
		return BigDecimalUtil.paraMonetario(desconto);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Item> getCarrinho() {
		return ImmutableList.copyOf(carrinho);
	}

	public void setCarrinho(List<Item> carrinho) {
		this.carrinho = carrinho;
	}

	public List<Descontavel> getCupons() {
		return ImmutableList.copyOf(cupons);
	}

	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((participacao == null) ? 0 : participacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inscricao other = (Inscricao) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (participacao == null) {
			if (other.participacao != null)
				return false;
		} else if (!participacao.equals(other.participacao))
			return false;
		return true;
	}

	public boolean isPaga() {
		return isPaga;
	}

	public void setPaga(boolean isPaga) {
		this.isPaga = isPaga;
	}
}
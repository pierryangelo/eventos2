package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.excecoes.DescontoDoItemCompostoNaoPodeSerNegativoException;
import codes.wise.eventos.modelo.excecoes.ItemSimplesJaExisteNaListaDeItensCompostos;
import codes.wise.eventos.modelo.excecoes.ValorDoItemCompostoNaoPodeSerNegativoException;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

@Entity
@DiscriminatorValue("C")
public class ItemComposto extends Item {
	@ElementCollection
	private List<ItemSimples> itens = Lists.newArrayList();
	private String descricao;
	private BigDecimal desconto;
	private BigDecimal valor;
	
	public ItemComposto(BigDecimal valor, String descricao) 
			throws ValorDoItemCompostoNaoPodeSerNegativoException {
		if (!isValorNaoNegativo(valor)) {
			throw new ValorDoItemCompostoNaoPodeSerNegativoException();
		}
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public ItemComposto(String descricao, BigDecimal desconto) 
			throws DescontoDoItemCompostoNaoPodeSerNegativoException {
		if (!isValorNaoNegativo(desconto)) {
			throw new DescontoDoItemCompostoNaoPodeSerNegativoException();
		}
		this.desconto = BigDecimalUtil.paraMonetario(desconto);
		this.descricao = descricao;
	}

	private boolean isValorNaoNegativo(BigDecimal desconto)  {
		if (desconto.compareTo(BigDecimal.ZERO) == -1) {
			return false;
		}
		return true;
	}
	
	public void adicionarItem(ItemSimples item) 
			throws ItemSimplesJaExisteNaListaDeItensCompostos {
		if (this.itens.contains(item)) {
			throw new ItemSimplesJaExisteNaListaDeItensCompostos();
		}
		this.itens.add(item);
	}
	
	public List<ItemSimples> getItens() {
		return ImmutableList.copyOf(itens);
	}
	
	/**
	 * Se não tiver sido utilizado o construtor passando o valor, 
	 * automaticamente calcula o total a partir do desconto aplicado sobre
	 * a soma dos itens.
	 * @return total : BigDecimal
	 */
	@Override
	public BigDecimal getPreco() {
		if (this.valor != null) {
			return BigDecimalUtil.paraMonetario(valor);
		}
		BigDecimal total = itens.stream()
                .map(Item::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		total = total.subtract(total.multiply(this.desconto));
		return BigDecimalUtil.paraMonetario(total);
	}
	
	public void setDesconto(BigDecimal desconto) 
			throws DescontoDoItemCompostoNaoPodeSerNegativoException {
		if (!isValorNaoNegativo(desconto)) {
			throw new DescontoDoItemCompostoNaoPodeSerNegativoException();
		}
		this.desconto = BigDecimalUtil.paraMonetario(desconto);
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemComposto other = (ItemComposto) obj;
		if (desconto == null) {
			if (other.desconto != null)
				return false;
		} else if (!desconto.equals(other.desconto))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}

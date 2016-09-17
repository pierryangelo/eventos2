package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.excecoes.ItemSimplesJaExisteNaListaDeItensCompostos;
import codes.wise.eventos.modelo.util.BigDecimalUtil;

public class ItemComposto extends Item {
	public List<ItemSimples> itens;
	public String descricao;
	public BigDecimal desconto;
	
	public ItemComposto(BigDecimal preco, String descricao) {
		super(preco);
		this.itens = Lists.newArrayList();
		this.descricao = descricao;
	}
	
	public ItemComposto(String descricao, BigDecimal desconto) {
		this.desconto = BigDecimalUtil.paraMonetario(desconto);
		this.descricao = descricao;
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
		if (this.preco != null) {
			return BigDecimalUtil.paraMonetario(preco);
		}
		preco = new BigDecimal(0);
		itens.forEach(item -> {
			preco = preco.add(item.getPreco());
		});
		
		return BigDecimalUtil.paraMonetario(preco);
	}
	
	public void setDesconto(BigDecimal desconto) {
		this.desconto = BigDecimalUtil.paraMonetario(desconto);
	}
}

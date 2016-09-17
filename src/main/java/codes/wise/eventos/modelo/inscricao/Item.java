package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import codes.wise.eventos.modelo.util.BigDecimalUtil;

public abstract class Item {
	protected Long id;
	protected BigDecimal preco;

	public Item() {
	}
	
	public Item(BigDecimal preco) {
		this.preco = BigDecimalUtil.paraMonetario(preco);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = BigDecimalUtil.paraMonetario(preco);
	}
}

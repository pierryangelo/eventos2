package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import codes.wise.eventos.modelo.util.BigDecimalUtil;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	
	@OneToOne
	protected Inscricao inscricao;
	
	protected BigDecimal preco;

	public Item() {
	}
	
	public Item(BigDecimal preco) {
		this.preco = BigDecimalUtil.paraMonetario(preco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = BigDecimalUtil.paraMonetario(preco);
	}
}

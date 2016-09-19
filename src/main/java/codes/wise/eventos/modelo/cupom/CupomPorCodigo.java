package codes.wise.eventos.modelo.cupom;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CupomPorCodigo extends Cupom {
	private String codigo;
	
	public CupomPorCodigo(BigDecimal porcentagemDeDesconto, String codigo, Boolean isAtivo) {
		super(porcentagemDeDesconto);
		this.isAtivo = isAtivo;
		this.codigo = codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	@Override
	public Boolean isAtivo() {
		return this.isAtivo;
	}
}

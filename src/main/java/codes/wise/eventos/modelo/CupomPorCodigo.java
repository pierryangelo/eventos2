package codes.wise.eventos.modelo;

import java.math.BigDecimal;

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

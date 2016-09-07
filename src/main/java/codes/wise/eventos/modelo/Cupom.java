package codes.wise.eventos.modelo;

import java.math.BigDecimal;

public abstract class Cupom implements Descontavel {
	protected Boolean isAtivo;
	protected BigDecimal porcentagemDoDesconto;
	
	protected Cupom(BigDecimal porcentagemDoDesconto) {
		this.porcentagemDoDesconto = porcentagemDoDesconto;
	}
	
	public abstract Boolean isAtivo();

	public BigDecimal getPorcentagemDoDesconto() {
		return this.porcentagemDoDesconto;
	}
}

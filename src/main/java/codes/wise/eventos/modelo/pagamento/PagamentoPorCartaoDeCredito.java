package codes.wise.eventos.modelo.pagamento;

import java.math.BigDecimal;

import codes.wise.eventos.modelo.pagamento.FormaDePagamento;

public class PagamentoPorCartaoDeCredito implements FormaDePagamento {
	private BigDecimal saldo;
	public PagamentoPorCartaoDeCredito(BigDecimal saldo) {
		if (this.saldo.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Saldo Inválido!");
		}
		this.saldo = saldo;
	}
	
	@Override
	public boolean pagar(BigDecimal quantia) {
		if (quantia.compareTo(this.saldo) <= 0) {
			this.saldo = this.saldo.subtract(quantia);
			return true;
		}
		return false;
	}
}


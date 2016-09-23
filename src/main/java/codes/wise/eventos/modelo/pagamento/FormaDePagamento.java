package codes.wise.eventos.modelo.pagamento;

import java.math.BigDecimal;

public interface FormaDePagamento {
	boolean pagar(BigDecimal quantia);
}

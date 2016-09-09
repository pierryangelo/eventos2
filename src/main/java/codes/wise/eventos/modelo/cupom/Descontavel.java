package codes.wise.eventos.modelo.cupom;

import java.math.BigDecimal;

public interface Descontavel {
	Boolean isAtivo();
	BigDecimal getPorcentagemDoDesconto();
}

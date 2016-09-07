package codes.wise.eventos.modelo;

import java.math.BigDecimal;

public interface Descontavel {
	Boolean isAtivo();
	BigDecimal getPorcentagemDoDesconto();
}

package codes.wise.eventos.modelo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtil {
	public static BigDecimal paraMonetario(BigDecimal valor) {
		return valor.setScale(2, RoundingMode.CEILING);
	}
}

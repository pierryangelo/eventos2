package codes.wise.eventos.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalUtil {
	public static BigDecimal paraMonetario(BigDecimal valor) {
		return valor.setScale(2, RoundingMode.CEILING);
	}
}

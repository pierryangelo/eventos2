package codes.wise.eventos.modelo.util;

import java.time.LocalDateTime;

public class TimeUtil {
	/**
	 * Dados quatro LocalDateTime's, verifica se eles não são conflitantes.
	 * @param inicio1
	 * @param fim1
	 * @param inicio2
	 * @param fim2
	 * @return boolean
	 */
	public static boolean verificaConflitoDeHorarios(LocalDateTime inicio1, 
			LocalDateTime fim1, LocalDateTime inicio2, LocalDateTime fim2) {
		return (inicio2.isAfter(inicio1) && inicio2.isBefore(fim1)) 
				|| (fim2.isAfter(inicio1) && fim2.isBefore(fim1));
	}
}

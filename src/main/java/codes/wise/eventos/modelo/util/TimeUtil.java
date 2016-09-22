package codes.wise.eventos.modelo.util;

import java.time.LocalDateTime;

public class TimeUtil {
	/**
	 * Dados quatro LocalDateTimes, verifica se eles não são conflitantes.
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
	
	/**
	 * Verifica se as datas inicio e término estão contidas no limite inicial e final (inclusive).
	 * @param limiteInicial
	 * @param limiteFinal
	 * @param inicio
	 * @param termino
	 * @return boolean
	 */
	public static boolean dentroDoIntervalo(LocalDateTime limiteInicial, LocalDateTime limiteFinal, 
			LocalDateTime inicio, LocalDateTime termino) {
		return ((inicio.isAfter(limiteInicial) && inicio.isBefore(limiteFinal)) 
			&& (termino.isAfter(limiteInicial) && termino.isBefore(limiteFinal))); 
	}
	
	public static boolean dataDeInicioAnteriorADataAtual(LocalDateTime dataDeInicio) {
		return dataDeInicio.isBefore(LocalDateTime.now());
	}
}

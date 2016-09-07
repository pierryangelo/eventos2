package codes.wise.eventos.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CupomPorData extends Cupom {
	private LocalDateTime dataEHoraDeInicio;
	private LocalDateTime dataEHoraDeTermino;
	
	public CupomPorData(BigDecimal porcentagemDeDesconto, 
			LocalDateTime dataEHoraDeInicio, LocalDateTime dataEHoraDeTermino) {
		super(porcentagemDeDesconto);		
		this.dataEHoraDeInicio = dataEHoraDeInicio;
		this.dataEHoraDeTermino = dataEHoraDeTermino;
	}
	
	@Override
	public Boolean isAtivo() {
		LocalDateTime dataEHoraAtual = LocalDateTime.now();
		return dataEHoraAtual.isAfter(dataEHoraDeInicio) && dataEHoraAtual.isBefore(dataEHoraDeTermino);
	}
}

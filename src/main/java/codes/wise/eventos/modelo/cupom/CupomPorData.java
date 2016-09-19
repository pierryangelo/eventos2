package codes.wise.eventos.modelo.cupom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
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

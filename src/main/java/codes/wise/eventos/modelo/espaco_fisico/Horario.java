package codes.wise.eventos.modelo.espaco_fisico;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
@Embeddable
public class Horario {
	private LocalDateTime inicio;
	private LocalDateTime termino;
	
	public Horario(LocalDateTime inicio, LocalDateTime termino) {
		this.inicio = inicio;
		this.termino = termino;
	}
	
	public LocalDateTime getInicio() {
		return inicio;
	}
	
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	
	public LocalDateTime getTermino() {
		return termino;
	}
	public void setTermino(LocalDateTime termino) {
		this.termino = termino;
	}

}

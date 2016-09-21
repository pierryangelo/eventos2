package codes.wise.eventos.modelo.agenda;

import java.time.LocalDateTime;

public interface Agendavel {
	LocalDateTime getInicio();
	LocalDateTime getTermino();
}
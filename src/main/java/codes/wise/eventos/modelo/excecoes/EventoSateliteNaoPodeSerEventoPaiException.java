package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class EventoSateliteNaoPodeSerEventoPaiException extends Exception {
	public EventoSateliteNaoPodeSerEventoPaiException() {
		super("Evento satélite não pode ser o evento pai!");
	}
}

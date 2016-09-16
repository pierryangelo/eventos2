package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class EventoSateliteJaAdicionadoException extends Exception {
	public EventoSateliteJaAdicionadoException() {
		super("Evento satélite já adicionado!");
	}
}

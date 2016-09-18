package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class EventoNaoContemCupomException extends Exception {
	public EventoNaoContemCupomException() {
		super("Evento não contém este cupom!");
	}
}

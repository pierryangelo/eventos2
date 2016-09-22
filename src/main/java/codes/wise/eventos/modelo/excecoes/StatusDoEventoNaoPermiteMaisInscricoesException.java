package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class StatusDoEventoNaoPermiteMaisInscricoesException extends Exception {
	public StatusDoEventoNaoPermiteMaisInscricoesException() {
		super("Evento não está mais recebendo inscrições!");
	}
}

package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class StatusDoEventoNaoPermiteFazerCheckinException extends Exception {
	public StatusDoEventoNaoPermiteFazerCheckinException() {
		super("Status do evento não permite fazer checkin!");
	}
}

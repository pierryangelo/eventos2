package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException extends Exception {
	public HorarioDaAtividadeNaoCorrespondeAoIntervaloDoEventoException() {
		super("Horário da atividade está fora do intervalo de horário do evento!");
	}
}

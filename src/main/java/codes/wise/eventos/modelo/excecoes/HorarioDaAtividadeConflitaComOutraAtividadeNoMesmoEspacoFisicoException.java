package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException extends Exception {
	public HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException() {
		super("Horário da atividade a ser adicionada conflita com o horário de outra atividade!");
	}
}

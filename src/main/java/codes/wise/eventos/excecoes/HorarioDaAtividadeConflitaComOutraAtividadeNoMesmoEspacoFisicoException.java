package codes.wise.eventos.excecoes;

@SuppressWarnings("serial")
public class HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException extends Exception {
	public HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException() {
		super("Horário da atividade a ser adicionada conflita com o horário de outra atividade!");
	}
}

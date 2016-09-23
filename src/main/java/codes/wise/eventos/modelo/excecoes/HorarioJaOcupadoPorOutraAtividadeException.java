package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class HorarioJaOcupadoPorOutraAtividadeException extends Exception {
	public HorarioJaOcupadoPorOutraAtividadeException() {
		super("Horário já ocupado com outra atividade exception!");
	}
}

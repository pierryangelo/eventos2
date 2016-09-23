package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class NaoHaHorarioDisponivelNoEspacoFisicoException extends Exception {
	public NaoHaHorarioDisponivelNoEspacoFisicoException() {
		super("Não há horário disponível no espaço físico!");
	}
}

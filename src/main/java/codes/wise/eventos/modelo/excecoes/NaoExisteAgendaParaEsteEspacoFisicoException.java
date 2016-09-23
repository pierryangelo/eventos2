package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class NaoExisteAgendaParaEsteEspacoFisicoException extends Exception {
	public NaoExisteAgendaParaEsteEspacoFisicoException() {
		super("Não existe agenda para este espaço físico!");
	}
}

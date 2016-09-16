package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class JaExisteEspacoFisicoAdicionadoException extends Exception {
	public JaExisteEspacoFisicoAdicionadoException() {
		super("Esse espaço físico já está adicionado a este evento!");
	}
}

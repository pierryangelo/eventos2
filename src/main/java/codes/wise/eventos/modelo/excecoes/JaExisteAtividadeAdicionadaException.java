package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class JaExisteAtividadeAdicionadaException extends Exception {
	public JaExisteAtividadeAdicionadaException() {
		super("Esta atividade já está adicionada ao evento!");
	}
}

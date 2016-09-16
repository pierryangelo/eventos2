package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class InscricaoJaExisteException extends Exception {
	public InscricaoJaExisteException() {
		super("Inscricao já existe!");
	}
}

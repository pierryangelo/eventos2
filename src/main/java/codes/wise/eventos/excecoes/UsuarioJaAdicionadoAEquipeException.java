package codes.wise.eventos.excecoes;

@SuppressWarnings("serial")
public class UsuarioJaAdicionadoAEquipeException extends Exception {
	public UsuarioJaAdicionadoAEquipeException() {
		super("Usuário já adicionado à equipe!");
	}
}

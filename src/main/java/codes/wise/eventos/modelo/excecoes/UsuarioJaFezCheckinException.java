package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class UsuarioJaFezCheckinException extends Exception {
	public UsuarioJaFezCheckinException() {
		super("Usuário já fez checkin!");
	}
}

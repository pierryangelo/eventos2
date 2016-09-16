package codes.wise.eventos.excecoes;

@SuppressWarnings("serial")
public class UsuarioJaFezCheckinException extends Exception {
	public UsuarioJaFezCheckinException() {
		super("Usuário já fez checkin!");
	}
}

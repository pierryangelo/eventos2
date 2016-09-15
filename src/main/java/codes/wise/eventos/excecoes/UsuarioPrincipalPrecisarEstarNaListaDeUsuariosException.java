package codes.wise.eventos.excecoes;

@SuppressWarnings("serial")
public class UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException extends Exception {
	public UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException() {
		super("Usuário principal precisa estar na lista de usuários da equipe!");
	}
}

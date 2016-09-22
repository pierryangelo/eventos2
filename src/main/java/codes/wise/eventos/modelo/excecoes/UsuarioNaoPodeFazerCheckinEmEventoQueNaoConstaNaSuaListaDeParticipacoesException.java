package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class UsuarioNaoPodeFazerCheckinEmEventoQueNaoConstaNaSuaListaDeParticipacoesException extends Exception {
	public UsuarioNaoPodeFazerCheckinEmEventoQueNaoConstaNaSuaListaDeParticipacoesException() {
		super("Usuário não pode fazer checkin em evento que não consta na sua lista de participações!");
	}
}

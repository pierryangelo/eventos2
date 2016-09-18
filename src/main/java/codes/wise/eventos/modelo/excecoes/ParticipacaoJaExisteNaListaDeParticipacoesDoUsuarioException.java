package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class ParticipacaoJaExisteNaListaDeParticipacoesDoUsuarioException extends Exception {
	public ParticipacaoJaExisteNaListaDeParticipacoesDoUsuarioException() {
		super("Participação já existe na lista de participações do usuário!");
	}
}

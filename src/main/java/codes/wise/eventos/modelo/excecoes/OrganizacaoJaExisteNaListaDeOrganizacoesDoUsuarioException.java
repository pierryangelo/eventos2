package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class OrganizacaoJaExisteNaListaDeOrganizacoesDoUsuarioException extends Exception {
	public OrganizacaoJaExisteNaListaDeOrganizacoesDoUsuarioException() {
		super("Organização já existe na lista de organizações do usuário!");
	}
}

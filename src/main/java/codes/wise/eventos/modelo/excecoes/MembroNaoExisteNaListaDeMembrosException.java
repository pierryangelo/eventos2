package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class MembroNaoExisteNaListaDeMembrosException extends Exception {
	public MembroNaoExisteNaListaDeMembrosException() {
		super("Membro não existe na lista de membros!");
	}
}

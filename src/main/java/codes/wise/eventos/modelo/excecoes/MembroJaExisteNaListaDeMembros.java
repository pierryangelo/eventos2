package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class MembroJaExisteNaListaDeMembros extends Exception {
	public MembroJaExisteNaListaDeMembros() {
		super("Membro já existe na lista de membros!");
	}
}

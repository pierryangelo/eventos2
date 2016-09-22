package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class ItemNaoExisteNaCestaException extends Exception {
	public ItemNaoExisteNaCestaException() {
		super("Item não está adicionado na cesta!");
	}
}

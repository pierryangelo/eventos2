package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class ItemJaAdicionadoAoCarrinhoException extends Exception {
	public ItemJaAdicionadoAoCarrinhoException() {
		super("Item já adicionado ao carrinho!");
	}
}

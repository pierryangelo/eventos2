package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class ItemSimplesJaExisteEmUmItemCompostoException extends Exception {
	public ItemSimplesJaExisteEmUmItemCompostoException() {
		super("Item simples já existe em algum item composto!");
	}
}

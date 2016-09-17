package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class ItemSimplesJaExisteNaListaDeItensCompostos extends Exception {
	public ItemSimplesJaExisteNaListaDeItensCompostos() {
		super("Item simples já existe na lista de itens compostos!");
	}
}

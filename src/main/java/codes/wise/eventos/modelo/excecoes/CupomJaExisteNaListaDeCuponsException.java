package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class CupomJaExisteNaListaDeCuponsException extends Exception {
	public CupomJaExisteNaListaDeCuponsException() {
		super("Cupom já existe na lista de cupons!");
	}
}

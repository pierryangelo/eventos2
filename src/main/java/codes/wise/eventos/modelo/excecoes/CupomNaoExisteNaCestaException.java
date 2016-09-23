package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class CupomNaoExisteNaCestaException extends Exception {
	public CupomNaoExisteNaCestaException() {
		super("Cupom não está adicionado à cesta!");
	}
}

package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class JaExisteUmCupomComEsteCodigoException extends Exception {
	public JaExisteUmCupomComEsteCodigoException() {
		super("Já existe um cupom com este código na lista de cupons!");
	}
}

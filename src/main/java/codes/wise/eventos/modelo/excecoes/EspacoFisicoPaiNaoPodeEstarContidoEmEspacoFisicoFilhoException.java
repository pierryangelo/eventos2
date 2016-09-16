package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException extends Exception {
	public EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException() {
		super("Espaço físico pai não pode estar contido em espaço físico filho");
	}
}

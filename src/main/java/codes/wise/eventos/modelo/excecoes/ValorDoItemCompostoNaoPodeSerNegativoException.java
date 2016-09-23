package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class ValorDoItemCompostoNaoPodeSerNegativoException extends Exception {
	public ValorDoItemCompostoNaoPodeSerNegativoException() {
		super("Valor do item composto não pode ser negativo!");
	}
 }

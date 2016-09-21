package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class DescontoDoItemCompostoNaoPodeSerNegativoException extends Exception {
	public DescontoDoItemCompostoNaoPodeSerNegativoException() {
		super("Desconto do item composto deve ser um valor igual ou maior que zero!");
	}
}

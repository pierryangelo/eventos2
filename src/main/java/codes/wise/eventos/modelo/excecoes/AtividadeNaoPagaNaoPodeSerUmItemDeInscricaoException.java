package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException extends Exception {
	public AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException() {
		super("Atividade não paga não pode ser um item de inscrição!");
	}
}

package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException extends Exception {
	public StatusDoEventoNaoPermiteAdicaoDeNovasAtividadesException() {
		super("Status do evento não permite adição de novas atividades!");
	}
}

package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class NaoExisteAtividadeNaListaDeAtividadesDoEventoException extends Exception {
	public NaoExisteAtividadeNaListaDeAtividadesDoEventoException() {
		super("Não existe atividade na lista de atividades do evento!");
	}
}

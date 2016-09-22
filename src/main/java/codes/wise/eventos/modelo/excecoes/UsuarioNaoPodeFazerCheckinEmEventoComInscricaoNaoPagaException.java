package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class UsuarioNaoPodeFazerCheckinEmEventoComInscricaoNaoPagaException extends Exception {
	public UsuarioNaoPodeFazerCheckinEmEventoComInscricaoNaoPagaException() {
		super("Usuário não pode fazer checkin em evento com inscrição não paga!");
	}
}

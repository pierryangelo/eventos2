package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class DatasDeInicioEFimDoEventoSateliteNaoPodemEstarForaDoIntervaloDoEventoException extends Exception {
	public DatasDeInicioEFimDoEventoSateliteNaoPodemEstarForaDoIntervaloDoEventoException() {
		super("Datas de início e fim do evento satélite devem estar dentro do intervalo do evento principal!");
	}
}

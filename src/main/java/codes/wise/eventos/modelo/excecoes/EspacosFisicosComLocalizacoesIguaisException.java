package codes.wise.eventos.modelo.excecoes;

@SuppressWarnings("serial")
public class EspacosFisicosComLocalizacoesIguaisException extends Exception {
	public EspacosFisicosComLocalizacoesIguaisException() {
		super("Espaços físicos com localizações iguais!");
	}
}

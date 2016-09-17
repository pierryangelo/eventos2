package codes.wise.eventos.modelo.usuario;

import codes.wise.eventos.modelo.evento.Evento;

public class Organizacao {
	private Equipe equipe;
	private Evento evento;
	
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}

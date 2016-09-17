package codes.wise.eventos.modelo.usuario;

import codes.wise.eventos.modelo.evento.Evento;

public class Organizacao {
	private EquipeOrganizadora equipe;
	private Evento evento;
	
	public EquipeOrganizadora getEquipe() {
		return equipe;
	}
	public void setEquipe(EquipeOrganizadora equipe) {
		this.equipe = equipe;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}

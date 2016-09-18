package codes.wise.eventos.modelo.usuario;

import codes.wise.eventos.modelo.evento.Evento;

public class Organizacao {
	private Integer id;
	private Usuario usuario;
	private Evento evento;
	private EquipeOrganizadora equipeOrganizadora;
	
	public Organizacao() {}
	
	public Organizacao(Evento evento, EquipeOrganizadora equipeOrganizadora, Usuario usuario) {
		this.evento = evento;
		this.equipeOrganizadora = equipeOrganizadora;
		this.usuario = usuario;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public EquipeOrganizadora getEquipeOrganizadora() {
		return equipeOrganizadora;
	}

	public void setEquipeOrganizadora(EquipeOrganizadora equipeOrganizadora) {
		this.equipeOrganizadora = equipeOrganizadora;
	}
}

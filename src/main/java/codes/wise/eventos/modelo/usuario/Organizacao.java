package codes.wise.eventos.modelo.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import codes.wise.eventos.modelo.evento.Evento;

@Entity
public class Organizacao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Evento evento;
	@OneToOne
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

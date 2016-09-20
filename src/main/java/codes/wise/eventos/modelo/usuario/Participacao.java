package codes.wise.eventos.modelo.usuario;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import codes.wise.eventos.modelo.inscricao.Inscricao;

@Entity
public class Participacao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Inscricao inscricao;
	@Enumerated(EnumType.STRING)
	private TipoDeParticipante tipoDeParticipante;
	
	public Participacao() {
		
	}
	
	public Participacao(Inscricao inscricao, TipoDeParticipante tipoDeParticipante, Usuario usuario) {
		this.inscricao = inscricao;
		this.tipoDeParticipante = tipoDeParticipante;
		this.usuario = usuario;
	}
	
	public Inscricao getInscricao() {
		return inscricao;
	}
	
	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
	
	public TipoDeParticipante getTipoDeParticipante() {
		return tipoDeParticipante;
	}
	
	public void setTipoDeParticipante(TipoDeParticipante tipoDeParticipante) {
		this.tipoDeParticipante = tipoDeParticipante;
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
}

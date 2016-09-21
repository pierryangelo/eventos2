package codes.wise.eventos.modelo.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Responsavel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Usuario usuario;
	private String curriculo;
	
	public Responsavel(Usuario usuario, String curriculo) {
		this.usuario = usuario;
		this.curriculo = curriculo;
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
	
	public void setPessoa(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getCurriculo() {
		return curriculo;
	}
	
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
}

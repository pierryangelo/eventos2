package codes.wise.eventos.modelo.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import codes.wise.eventos.modelo.atividade.Atividade;

@Entity
public class Responsavel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Pessoa pessoa;
	private String curriculo;
	
	public Responsavel(Pessoa pessoa, String curriculo) {
		this.pessoa = pessoa;
		this.curriculo = curriculo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public String getCurriculo() {
		return curriculo;
	}
	
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
}

package codes.wise.eventos.modelo.atividade;

import codes.wise.eventos.modelo.usuario.Pessoa;

public class Responsavel {
	private Pessoa pessoa;
	private String curriculo;
	
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

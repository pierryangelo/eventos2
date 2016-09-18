package codes.wise.eventos.modelo.usuario;

import codes.wise.eventos.modelo.inscricao.Inscricao;

public class Participacao {
	private Integer id;
	private Usuario usuario;
	private Inscricao inscricao;
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
}

package codes.wise.eventos.modelo.usuario;

import codes.wise.eventos.modelo.inscricao.Inscricao;

public class Participacao {
	private Inscricao inscricao;
	private TipoDeParticipante tipoDeParticipante;
	
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

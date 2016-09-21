package codes.wise.eventos.modelo.atividade;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.usuario.EquipeOrganizadora;
import codes.wise.eventos.modelo.usuario.EquipeResponsavel;

public class AtividadeBuilder {
	private Atividade atividade;
	
	public AtividadeBuilder() {
		this.atividade = new Atividade();
	}
	
	public AtividadeBuilder comNome(String nome) {
		this.atividade.setNome(nome);
		return this;
	}
	
	public AtividadeBuilder doEvento(Evento evento) {
		this.atividade.setEvento(evento);
		return this;
	}
	
	public AtividadeBuilder comInicio(LocalDateTime inicio) {
		this.atividade.setInicio(inicio);
		return this;
	}
	
	public AtividadeBuilder comTermino(LocalDateTime termino) {
		this.atividade.setTermino(termino);
		return this;
	}
	
	public AtividadeBuilder noEspacoFisico(EspacoFisico espacoFisico) 
			throws HorarioJaOcupadoPorOutraAtividadeException {
		this.atividade.setEspacoFisico(espacoFisico);
		return this;
	}
	
	public AtividadeBuilder deTipo(TipoDeAtividade tipoDeAtividade) {
		this.atividade.setTipoDeAtividade(tipoDeAtividade);
		return this;
	}
	
	public AtividadeBuilder comEquipeResponsavel(EquipeResponsavel equipeResponsavel) {
		this.atividade.setEquipeResponsavel(equipeResponsavel);
		return this;
	}
	
	public AtividadeBuilder comValor(BigDecimal valor) {
		this.atividade.setValor(valor);
		return this;
	}
	
	public AtividadeBuilder isPaga(Boolean isPaga) {
		this.atividade.setIsPaga(isPaga);
		return this;
	}
	
	public Atividade getAtividade() {
		return this.atividade;
	}
}

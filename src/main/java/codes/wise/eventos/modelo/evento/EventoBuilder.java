package codes.wise.eventos.modelo.evento;

import java.time.LocalDateTime;

public class EventoBuilder {
	protected Evento evento;
	
	public EventoBuilder() {
		this.evento = new Evento();
	}
	
	public EventoBuilder comNome(String nome) {
		this.evento.setNome(nome);
		return this;
	}
	public EventoBuilder comDescricao(String descricao) {
		this.evento.setDescricao(descricao);
		return this;
	}
	public EventoBuilder comInicio(LocalDateTime inicio) {
		this.evento.setInicio(inicio);
		return this;
	}
	
	public EventoBuilder comTermino(LocalDateTime termino) {
		this.evento.setTermino(termino);
		return this;
	}
	
	public EventoBuilder deTipo(TipoDeEvento tipoDeEvento) {
		this.evento.setTipo(tipoDeEvento);
		return this;
	}
	public EventoBuilder comPai(Evento eventoPai) {
		this.evento.setEventoPai(eventoPai);
		return this;
	}
	
	public Evento getEvento() {
		return this.evento;
	}
}

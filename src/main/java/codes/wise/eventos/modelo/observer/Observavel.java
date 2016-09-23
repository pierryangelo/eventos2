package codes.wise.eventos.modelo.observer;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class Observavel {
	private List<Observador> observadores;
	protected Notificacao notificacao;
	
	public Observavel() {
		this.observadores = Lists.newArrayList();
	}
	
	public void adicionarObservador(Observador obs) {
		this.observadores.add(obs);
	}
	
	public void removerObservador(Observador obs) {
		this.observadores.remove(obs);
	}
	
	public void notificarObservadores() { 
		this.observadores.forEach(o -> o.atualizar(this.notificacao));
	}
	
	public void setNotificacao(String notificacao) {
		this.notificacao = new Notificacao(notificacao);
	}
	
	public Notificacao getNotificacao() {
		return this.notificacao;
	}
	
	public void clearNotification() {
		this.notificacao = null;
	}
}
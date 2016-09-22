package codes.wise.eventos.modelo.observer;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notificacao {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime dataEHora;

	private String notificacao;
	
	public Notificacao(String notificacao) {
		this.dataEHora = LocalDateTime.now();
		this.notificacao = notificacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataEHora() {
		return dataEHora;
	}
	public void setDataEHora(LocalDateTime dataEHora) {
		this.dataEHora = dataEHora;
	}
	public String getNotificacao() {
		return notificacao;
	}
	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}
	
	@Override
	public String toString() {
		return "Notificacao [" + dataEHora.toString() + ", notificacao=" + notificacao + "]";
	}
}

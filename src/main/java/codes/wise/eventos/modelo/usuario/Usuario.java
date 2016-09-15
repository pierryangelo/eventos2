package codes.wise.eventos.modelo.usuario;

import java.time.LocalDateTime;
import java.util.List;

import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.evento.Evento;

public class Usuario {
	private Integer id;
	private LocalDateTime dataCadastro;
	private String email;
	private String password; 
	private Pessoa dados;
	private Boolean isAtivo;
	private List<Evento> meusEventos;
	private List<Evento> eventosQueEstouInscrito;

	public Usuario() {
		this.meusEventos = Lists.newArrayList();
		this.eventosQueEstouInscrito = Lists.newArrayList();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Pessoa getDados() {
		return dados;
	}

	public void setDados(Pessoa dados) {
		this.dados = dados;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public List<Evento> getMeusEventos() {
		return meusEventos;
	}

	public void setMeusEventos(List<Evento> meusEventos) {
		this.meusEventos = meusEventos;
	}

	public List<Evento> getEventosQueEstouInscrito() {
		return eventosQueEstouInscrito;
	}

	public void setEventosQueEstouInscrito(List<Evento> eventosQueEstouInscrito) {
		this.eventosQueEstouInscrito = eventosQueEstouInscrito;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", dados=" + dados + "]";
	}
}

package codes.wise.eventos.modelo.usuario;

import java.time.LocalDateTime;
import java.util.List;

import com.google.common.collect.Lists;

public class Usuario {
	private Integer id;
	private LocalDateTime dataCadastro;
	private String email;
	private String password; 
	private Pessoa dadosPessoais;
	private Boolean isAtivo;
	private List<Organizacao> organizacoes;
	private List<Participacao> participacoes;

	public Usuario() {
		this.organizacoes = Lists.newArrayList();
		this.participacoes = Lists.newArrayList();
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
		return dadosPessoais;
	}

	public void setDados(Pessoa dados) {
		this.dadosPessoais = dados;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public List<Organizacao> getOrganizacoes() {
		return this.organizacoes;
	}

	public void setMeusEventos(List<Organizacao> organizacoes) {
		this.organizacoes = organizacoes;
	}

	public List<Participacao> getParticipacoes() {
		return this.participacoes;
	}

	public void setEventosQueEstouInscrito(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
}

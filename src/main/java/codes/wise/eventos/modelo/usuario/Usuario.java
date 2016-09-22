package codes.wise.eventos.modelo.usuario;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.OrganizacaoJaExisteNaListaDeOrganizacoesDoUsuarioException;
import codes.wise.eventos.modelo.excecoes.ParticipacaoJaExisteNaListaDeParticipacoesDoUsuarioException;
import codes.wise.eventos.modelo.excecoes.StatusDoEventoNaoPermiteFazerCheckinException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaFezCheckinException;
import codes.wise.eventos.modelo.excecoes.UsuarioNaoPodeFazerCheckinEmEventoComInscricaoNaoPagaException;
import codes.wise.eventos.modelo.excecoes.UsuarioNaoPodeFazerCheckinEmEventoQueNaoConstaNaSuaListaDeParticipacoesException;
import codes.wise.eventos.modelo.inscricao.Inscricao;

@Entity
public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime dataCadastro;
	private String email;
	private String password; 
	private Boolean isAtivo;
	@OneToOne
	private Pessoa pessoa;

	@OneToMany(mappedBy="usuario")
	private List<Organizacao> organizacoes;
	@OneToMany(mappedBy="usuario")
	private List<Participacao> participacoes;

	public Usuario() {
		this.organizacoes = Lists.newArrayList();
		this.participacoes = Lists.newArrayList();
	}
	
	public void adicionarParticipacao(Participacao participacao) 
			throws ParticipacaoJaExisteNaListaDeParticipacoesDoUsuarioException {
		if (this.participacoes.contains(participacao)) {
			throw new ParticipacaoJaExisteNaListaDeParticipacoesDoUsuarioException();
		}
		this.participacoes.add(participacao);
	}
	
	public void adicionarOrganizacao(Organizacao organizacao) 
			throws OrganizacaoJaExisteNaListaDeOrganizacoesDoUsuarioException {
		if (this.organizacoes.contains(organizacao)) {
			throw new OrganizacaoJaExisteNaListaDeOrganizacoesDoUsuarioException();
		}
		this.organizacoes.add(organizacao);
	}
	
	/**
	 * Faz checkin do usuário em um evento que conste em sua lista de participações e o qual 
	 * a inscrição está paga.
	 * 
	 * @param evento
	 * @throws UsuarioNaoPodeFazerCheckinEmEventoComInscricaoNaoPagaException
	 * @throws UsuarioNaoPodeFazerCheckinEmEventoQueNaoConstaNaSuaListaDeParticipacoesException
	 * @throws UsuarioJaFezCheckinException
	 * @throws StatusDoEventoNaoPermiteFazerCheckinException 
	 */
	public void fazerCheckin(Evento evento) 
			throws UsuarioNaoPodeFazerCheckinEmEventoComInscricaoNaoPagaException, 
			UsuarioNaoPodeFazerCheckinEmEventoQueNaoConstaNaSuaListaDeParticipacoesException, 
			UsuarioJaFezCheckinException, StatusDoEventoNaoPermiteFazerCheckinException {
		
		for (Participacao participacao : this.participacoes) {
			Inscricao inscricao = participacao.getInscricao();
			if (!inscricao.isPaga()) {
				throw new UsuarioNaoPodeFazerCheckinEmEventoComInscricaoNaoPagaException();
			}
			if (!inscricao.getEvento().equals(evento)) {
				throw new UsuarioNaoPodeFazerCheckinEmEventoQueNaoConstaNaSuaListaDeParticipacoesException();
			}
			evento.fazerCheckin(this);
		}
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setOrganizacoes(List<Organizacao> organizacoes) {
		this.organizacoes = organizacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	@Override
	public String toString() {
		return "Usuario [dataCadastro=" + dataCadastro + ", email=" + email + ", password=" + password + ", isAtivo="
				+ isAtivo + ", organizacoes=" + organizacoes + ", participacoes=" + participacoes + "]";
	}
}

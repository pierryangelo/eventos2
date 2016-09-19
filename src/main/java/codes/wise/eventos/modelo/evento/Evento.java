package codes.wise.eventos.modelo.evento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import codes.wise.eventos.modelo.agenda.Agenda;
import codes.wise.eventos.modelo.agenda.Agendavel;
import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.cupom.Cupom;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.excecoes.EventoSateliteJaAdicionadoException;
import codes.wise.eventos.modelo.excecoes.EventoSateliteNaoPodeSerEventoPaiException;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.modelo.excecoes.InscricaoJaExisteException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.modelo.excecoes.JaExisteEspacoFisicoAdicionadoException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaFezCheckinException;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.usuario.Usuario;

@Entity
public class Evento implements Agendavel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Evento eventoPai;
	private String nome;
	private String descricao;
	private LocalDateTime inicio;
	private LocalDateTime termino;
	@Enumerated(EnumType.STRING)
	private TipoDeEvento tipo;
	private StatusDoEvento status;
	@OneToMany
	private List<Atividade> atividades;
	@ElementCollection
	private List<Cupom> cupons;
	@OneToMany
	private List<EspacoFisico> espacosFisicos;
	@ElementCollection
	private List<Evento> eventosSatelites;
	@ElementCollection
	private Set<Usuario> checkins;
	@ElementCollection
	private List<Inscricao> inscricoes;
	
	public Evento() {
		this.atividades = Lists.newArrayList();
		this.cupons = Lists.newArrayList();
		this.espacosFisicos = Lists.newArrayList();
		this.eventosSatelites = Lists.newArrayList();
		this.checkins = Sets.newHashSet();
		this.inscricoes = Lists.newArrayList();
	}
	
	public void adicionarInscricao(Inscricao inscricao) 
			throws InscricaoJaExisteException {
		if (this.inscricoes.contains(inscricao)) {
			throw new InscricaoJaExisteException();
		}
		this.inscricoes.add(inscricao);
	}
	
	public void adicionaEventoSatelite(Evento eventoSatelite) 
			throws EventoSateliteJaAdicionadoException, EventoSateliteNaoPodeSerEventoPaiException {
		if (this.eventosSatelites.contains(eventoSatelite)) {
			throw new EventoSateliteJaAdicionadoException();
		}
		if (eventoSatelite.equals(this)) {
			throw new EventoSateliteNaoPodeSerEventoPaiException();
		}
		this.eventosSatelites.add(eventoSatelite);
	}
	
	public void fazerCheckin(Usuario usuario) 
			throws UsuarioJaFezCheckinException {
		if (this.checkins.contains(usuario)) {
			throw new UsuarioJaFezCheckinException();
		}
		this.checkins.add(usuario);
	}
	
	// to do: hashCode e equals
	public void adicionaAtividade(Atividade atividade, EspacoFisico espacoFisico) 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException {
		if (this.atividades.contains(atividade)) {
			throw new JaExisteAtividadeAdicionadaException();
		}
		espacoFisico.adicionaAtividade(atividade);
		this.atividades.add(atividade);
	}
	
	public void adicionaEspacoFisico(EspacoFisico espacoFisico) 
			throws JaExisteEspacoFisicoAdicionadoException {
		if (this.espacosFisicos.contains(espacoFisico)) {
			throw new JaExisteEspacoFisicoAdicionadoException();
		}
		this.espacosFisicos.add(espacoFisico);
	}
	
	/**
	 * Retorna agenda do evento ordenada por data de início das atividades.
	 * @return String
	 */
	public String getAgenda() {
		return Agenda.getAgendaOrdemCrescente(atividades);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getTermino() {
		return termino;
	}

	public void setTermino(LocalDateTime termino) {
		this.termino = termino;
	}

	public TipoDeEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}

	public StatusDoEvento getStatus() {
		return status;
	}

	public void setStatus(StatusDoEvento status) {
		this.status = status;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Cupom> getDescontaveis() {
		return cupons;
	}

	public void setDescontaveis(List<Cupom> descontaveis) {
		this.cupons = descontaveis;
	}

	public Evento getEventoPai() {
		return eventoPai;
	}

	public void setEventoPai(Evento eventoPai) {
		this.eventoPai = eventoPai;
	}
}
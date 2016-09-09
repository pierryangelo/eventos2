package codes.wise.eventos.modelo.evento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

import codes.wise.eventos.excecoes.EventoSateliteJaAdicionadoException;
import codes.wise.eventos.excecoes.EventoSateliteNaoPodeSerEventoPaiException;
import codes.wise.eventos.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.excecoes.JaExisteAtividadeAdicionadaException;
import codes.wise.eventos.excecoes.JaExisteEspacoFisicoAdicionadoException;
import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.cupom.Descontavel;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;

public class Evento {
	private Evento eventoPai;
	private Integer id;
	private String nome;
	private String descricao;
	private LocalDate inicio;
	private LocalDate termino;
	private TipoDeEvento tipo;
	private StatusDoEvento status;
	// private StatusEvento statusEvento; # State Pattern
	private Visibilidade visibilidade;
	private List<Atividade> atividades;
	private List<Descontavel> descontaveis;
	private List<EspacoFisico> espacosFisicos;
	private List<Evento> eventosSatelites;
	
	public Evento() {
		atividades = Lists.newArrayList();
		descontaveis = Lists.newArrayList();
		espacosFisicos = Lists.newArrayList();
		eventosSatelites = Lists.newArrayList();
	}
	
	public void adicionaEventoSatelite(Evento eventoSatelite) 
			throws EventoSateliteJaAdicionadoException, EventoSateliteNaoPodeSerEventoPaiException {
		if (eventosSatelites.contains(eventoSatelite)) {
			throw new EventoSateliteJaAdicionadoException();
		}
		if (eventoSatelite.equals(this)) {
			throw new EventoSateliteNaoPodeSerEventoPaiException();
		}
		eventosSatelites.add(eventoSatelite);
	}
	
	// to do: hashCode e equals
	public void adicionaAtividade(Atividade atividade, EspacoFisico espacoFisico) 
			throws JaExisteAtividadeAdicionadaException, 
			HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException {
		if (atividades.contains(atividade)) {
			throw new JaExisteAtividadeAdicionadaException();
		}
		espacoFisico.adicionaAtividade(atividade);
		atividades.add(atividade);
	}
	
	public void adicionaEspacoFisico(EspacoFisico espacoFisico) 
			throws JaExisteEspacoFisicoAdicionadoException {
		if (espacosFisicos.contains(espacoFisico)) {
			throw new JaExisteEspacoFisicoAdicionadoException();
		}
		espacosFisicos.add(espacoFisico);
	}
	
	/**
	 * Retorna agenda do evento ordenada por data de início das atividades.
	 * @return String
	 */
	public String getAgenda() {
		StringBuilder texto = new StringBuilder();
		
		atividades.sort((a1, a2) -> a1.getDataEHoraDeInicio().compareTo(a2.getDataEHoraDeInicio()));
		atividades.forEach(a -> {
			texto.append("Atividade: " + a.getNome() + "\n" +
					"Inicia em: " + a.getDataEHoraDeInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");
		});
		
		return texto.toString();
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

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getTermino() {
		return termino;
	}

	public void setTermino(LocalDate termino) {
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

	public Visibilidade getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(Visibilidade visibilidade) {
		this.visibilidade = visibilidade;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Descontavel> getDescontaveis() {
		return descontaveis;
	}

	public void setDescontaveis(List<Descontavel> descontaveis) {
		this.descontaveis = descontaveis;
	}
}

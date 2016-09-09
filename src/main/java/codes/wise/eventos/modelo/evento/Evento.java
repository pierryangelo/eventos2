package codes.wise.eventos.modelo.evento;

import java.time.LocalDate;
import java.util.List;

import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.cupom.Descontavel;

public class Evento {
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
	
	public Evento() {
		atividades = Lists.newArrayList();
		descontaveis = Lists.newArrayList();
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

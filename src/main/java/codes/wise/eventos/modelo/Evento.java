package codes.wise.eventos.modelo;

import java.time.LocalDate;
import java.util.List;

import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.atividade.Atividade;

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
}

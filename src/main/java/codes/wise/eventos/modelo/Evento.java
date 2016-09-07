package codes.wise.eventos.modelo;

import java.time.LocalDate;
import java.util.List;

public class Evento {
	private Integer id;
	private String nome;
	private String descricao;
	private LocalDate inicio;
	private LocalDate termino;
	private TipoEvento tipoEvento;
	// private StatusEvento statusEvento; # State Pattern
	private Visibilidade visibilidade;
	private List<Atividade> atividades;
	private List<Descontavel> descontaveis;
}

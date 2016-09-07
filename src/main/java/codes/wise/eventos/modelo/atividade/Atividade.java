package codes.wise.eventos.modelo.atividade;

import java.time.LocalDateTime;

import codes.wise.eventos.modelo.Evento;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;

public abstract class Atividade {
	private Evento evento;
	private String nome;
	private LocalDateTime dataEHoraDeInicio;
	private LocalDateTime dataEHoraDeTermino;
	private EspacoFisico espacoFisico;
	
}

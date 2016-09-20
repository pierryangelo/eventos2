package codes.wise.eventos.modelo.agenda;

import java.time.format.DateTimeFormatter;

import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.evento.Evento;

public class Agenda {
	private Evento evento;
	
	public Agenda(Evento evento) {
		this.evento = evento;
	}
	
	public String getAgendaOrdemCrescente() {
		StringBuilder texto = new StringBuilder();
		this.evento.getAtividades().sort((a1, a2) -> a1.getInicio().compareTo(a2.getInicio()));
		this.evento.getAtividades().forEach(a -> {
			texto.append("Atividade: " + a.toString() + "\n" +
					"Inicia em: " + a.getInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");
		});
		return texto.toString();
	}

	public String getAgendaPorEspacoFisico(EspacoFisico espacoFisico) {
		StringBuilder texto = new StringBuilder();
		this.evento.getAtividades().sort((a1, a2) -> a1.getInicio().compareTo(a2.getInicio()));
		this.evento.getAtividades().forEach(a -> {
			if (a.getEspacoFisico().equals(espacoFisico)) {
				texto.append("Atividade: " + a.toString() + "\n" +
						"Inicia em: " + a.getInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");
			}
		});
		return texto.toString();
	}
}

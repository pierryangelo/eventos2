package codes.wise.evento.agenda;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Agenda {
	public static String getAgendaOrdemCrescente(List<? extends Agendavel> agendaveis) {
		StringBuilder texto = new StringBuilder();
		
		agendaveis.sort((a1, a2) -> a1.getInicio().compareTo(a2.getInicio()));
		agendaveis.forEach(a -> {
			texto.append("Atividade: " + a.toString() + "\n" +
					"Inicia em: " + a.getInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");
		});
		return texto.toString();
	}
}

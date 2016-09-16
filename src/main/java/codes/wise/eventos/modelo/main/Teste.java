package codes.wise.eventos.modelo.main;

import java.time.LocalDateTime;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;

public class Teste {
	public static void main(String[] args) throws JaExisteAtividadeAdicionadaException, HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException {
		Evento e1 = new Evento();
		e1.setNome("Simpósio");
		EspacoFisico ep1 = new EspacoFisico();
		ep1.setNome("Estádio Garrincha");
		Atividade a1 = new Atividade();
		a1.setId(1);
		Atividade a2 = new Atividade();
		a2.setId(2);
		a1.setInicio(LocalDateTime.of(2016, 10, 1, 17, 00));
		a2.setInicio(LocalDateTime.of(2016, 10, 6, 10, 00));
		a1.setTermino(LocalDateTime.of(2016, 10, 1, 20, 00));
		a2.setTermino(LocalDateTime.of(2016, 10, 6, 20, 00));
		e1.adicionaAtividade(a1, ep1);
		e1.adicionaAtividade(a2, ep1);
		System.out.println(e1.getAgenda());
	}
	
	
}

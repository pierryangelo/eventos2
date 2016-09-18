package codes.wise.eventos.modelo.main;

import java.time.LocalDateTime;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.excecoes.HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException;
import codes.wise.eventos.modelo.excecoes.JaExisteAtividadeAdicionadaException;

public class Teste {
	public static void main(String[] args) throws JaExisteAtividadeAdicionadaException, HorarioDaAtividadeConflitaComOutraAtividadeNoMesmoEspacoFisicoException {
		Evento e = new EventoBuilder().comNome("Novo Evento").comDescricao("Teste").comInicio(LocalDateTime.now()).getEvento();
		e.adicionaAtividade(new Atividade(), new EspacoFisico());

	}
	
	
}

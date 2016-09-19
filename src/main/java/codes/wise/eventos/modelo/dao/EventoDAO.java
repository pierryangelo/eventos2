package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.evento.Evento;

public class EventoDAO extends DAOGenerico<Evento> {
	public EventoDAO(EntityManager manager) {
		super(Evento.class, manager);
	}
}
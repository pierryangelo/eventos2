package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.atividade.Atividade;

public class AtividadeDAO extends DAOGenerico<Atividade> {
	public AtividadeDAO(EntityManager manager) {
		super(Atividade.class, manager);
	}
}

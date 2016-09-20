package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;

public class EspacoFisicoDAO extends DAOGenerico<EspacoFisico> {
	public EspacoFisicoDAO(EntityManager manager) {
		super(EspacoFisico.class, manager);
	}
}

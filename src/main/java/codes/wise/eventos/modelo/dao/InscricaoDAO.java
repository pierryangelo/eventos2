package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.inscricao.Inscricao;

public class InscricaoDAO extends DAOGenerico<Inscricao> {
	public InscricaoDAO(EntityManager manager) {
		super(Inscricao.class, manager);
	}
}
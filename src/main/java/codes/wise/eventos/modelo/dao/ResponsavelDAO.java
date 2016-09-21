package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.Responsavel;

public class ResponsavelDAO extends DAOGenerico<Responsavel> {
	public ResponsavelDAO(EntityManager manager) {
		super(Responsavel.class, manager);
	}
}

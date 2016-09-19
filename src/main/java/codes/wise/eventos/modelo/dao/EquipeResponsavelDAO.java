package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.EquipeResponsavel;

public class EquipeResponsavelDAO extends DAOGenerico<EquipeResponsavel> {
	public EquipeResponsavelDAO(EntityManager manager) {
		super(EquipeResponsavel.class, manager);
	}
}

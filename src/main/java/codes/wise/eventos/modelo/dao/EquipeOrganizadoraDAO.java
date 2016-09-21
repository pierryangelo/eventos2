package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.EquipeOrganizadora;

public class EquipeOrganizadoraDAO extends DAOGenerico<EquipeOrganizadora> {
	public EquipeOrganizadoraDAO(EntityManager manager) {
		super(EquipeOrganizadora.class, manager);
	}
}

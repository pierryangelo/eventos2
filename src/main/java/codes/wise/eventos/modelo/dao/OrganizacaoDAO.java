package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.Organizacao;

public class OrganizacaoDAO extends DAOGenerico<Organizacao> {
	public OrganizacaoDAO(EntityManager manager) {
		super(Organizacao.class, manager);
	}
}

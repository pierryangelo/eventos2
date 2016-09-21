package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.Participacao;

public class ParticipacaoDAO extends DAOGenerico<Participacao> {
	public ParticipacaoDAO(EntityManager manager) {
		super(Participacao.class, manager);
	}
}

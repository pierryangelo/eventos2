package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.Pessoa;

public class PessoaDAO extends DAOGenerico<Pessoa> {
	public PessoaDAO(EntityManager manager) {
		super(Pessoa.class, manager);
	}
}

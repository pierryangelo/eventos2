package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.usuario.Usuario;

public class UsuarioDAO extends DAOGenerico<Usuario>{
	public UsuarioDAO(EntityManager manager) {
		super(Usuario.class, manager);
	}
}

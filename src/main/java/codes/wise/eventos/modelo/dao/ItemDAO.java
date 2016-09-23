package codes.wise.eventos.modelo.dao;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.inscricao.Item;

public class ItemDAO extends DAOGenerico<Item>{
	public ItemDAO(EntityManager manager) {
		super(Item.class, manager);
	}
}

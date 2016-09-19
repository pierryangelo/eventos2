package codes.wise.eventos.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DAOGenerico<T> {
	protected EntityManager manager;
	protected Class<T> classe;
	
	public DAOGenerico(Class<T> classe, EntityManager manager) {
		this.classe = classe;
		this.manager = manager;
	}

	public void adiciona(T entidade) {
		manager.persist(entidade);
	}

	public void remove(Long id) {
		T entidade = manager.find(classe, id);
		manager.remove(entidade);
	}

	public T buscaPorId(Long id) {
		T entidade = manager.find(classe, id);
		return entidade;
	}

	public List<T> lista() {
		TypedQuery<T> query = manager.createQuery("select c from " + this.classe.getSimpleName()+ " c", this.classe);
		return query.getResultList();
	}

	public void altera(T entidade) {
		System.out.println(entidade);
		manager.merge(entidade);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
}
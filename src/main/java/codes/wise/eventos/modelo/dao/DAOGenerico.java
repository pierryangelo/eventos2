package codes.wise.eventos.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class DAOGenerico<T> {
	@PersistenceContext
	private EntityManager manager;
	private Class<T> classe;
	
	public DAOGenerico(Class<T> classe) {
		this.classe = classe;
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
		TypedQuery<T> query = manager.createQuery("select c from " + this.classe.getSimpleName()+" c", this.classe);
		return query.getResultList();
	}

	public void altera(T entidade) {
		System.out.println(entidade);
		manager.merge(entidade);
	}
}
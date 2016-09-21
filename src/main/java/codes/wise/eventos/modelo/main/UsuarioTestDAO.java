package codes.wise.eventos.modelo.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import codes.wise.eventos.modelo.dao.UsuarioDAO;
import codes.wise.eventos.modelo.usuario.Usuario;
import codes.wise.eventos.modelo.util.JPAUtil;

public class UsuarioTestDAO {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		
		em.getTransaction().begin();
		dao.adiciona(usuario1);
		dao.adiciona(usuario2);
		List<Usuario> lista = dao.lista();
		for (Usuario u : lista) {
			System.out.println(u);
		}
		em.getTransaction().commit();
		em.close();
		
		
		
	}
}

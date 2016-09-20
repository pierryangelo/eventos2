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
		usuario1.setNome("Fiódor Dostoiévski");
		usuario1.setDataCadastro(LocalDateTime.now());
		usuario1.setCpf("017212423292");
		usuario1.setEmail("fiodor@gmail.com");
		usuario1.setIsAtivo(true);
		usuario1.setDataNascimento(LocalDate.of(1900, 1, 1));
		usuario1.setEndereco("Av 07 de Setembro, 301");
		usuario1.setTelefone("86999671170");
		usuario1.setPassword("minhasenha123");
		usuario2.setNome("Nicola Tesla");
		usuario2.setPassword("12345");
		usuario2.setCpf("148343432297");
		usuario2.setDataNascimento(LocalDate.of(1860, 4, 20));
		usuario2.setDataCadastro(LocalDateTime.now());
		usuario2.setEndereco("Av Barao de Gurgueia, 3681");
		usuario2.setEmail("tesla@teslamotors.com");
		usuario2.setTelefone("8621073251");
		usuario2.setIsAtivo(true);
		
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

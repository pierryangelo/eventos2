package codes.wise.eventos.modelo.main;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import codes.wise.eventos.modelo.dao.EquipeOrganizadoraDAO;
import codes.wise.eventos.modelo.dao.EquipeResponsavelDAO;
import codes.wise.eventos.modelo.dao.ResponsavelDAO;
import codes.wise.eventos.modelo.dao.UsuarioDAO;
import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.usuario.EquipeOrganizadora;
import codes.wise.eventos.modelo.usuario.EquipeResponsavel;
import codes.wise.eventos.modelo.usuario.Pessoa;
import codes.wise.eventos.modelo.usuario.Responsavel;
import codes.wise.eventos.modelo.usuario.Usuario;
import codes.wise.eventos.modelo.usuario.UsuarioBuilder;

public class TesteEquipes {
	public static void main(String[] args) throws MembroJaExisteNaListaDeMembros {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");
		EntityManager em = emf.createEntityManager();
		EquipeResponsavelDAO equipeResponsavelDao = new EquipeResponsavelDAO(em);
		EquipeOrganizadoraDAO equipeOrganizadoraDao = new EquipeOrganizadoraDAO(em);
		UsuarioDAO usuarioDao = new UsuarioDAO(em);
		ResponsavelDAO responsavelDAO = new ResponsavelDAO(em);

		
		Pessoa pessoa1 = new Pessoa("Pierry Ângelo Pereira");
		Pessoa pessoa2 = new Pessoa("Nicola Tesla");
		
		Usuario usuario1 = new UsuarioBuilder()
				.comDataDeCadastro(LocalDateTime.now())
				.comEmail("pierryangelo@gmail.com")
				.infoPessoais(pessoa1)
				.ativo(true)
				.comSenha("supernova123")
				.getUsuario();
		
		Usuario usuario2 = new UsuarioBuilder()
				.comDataDeCadastro(LocalDateTime.now())
				.comEmail("tesla.nicola@teslamotors.com")
				.infoPessoais(pessoa2)
				.ativo(true)
				.comSenha("eletromagnetism")
				.getUsuario();
		
		Responsavel responsavel1 = new Responsavel(usuario1, "Curriculo");
		Responsavel responsavel2 = new Responsavel(usuario2, "Curriculo");
		
		System.out.println("IDs dos responsáveis:");
		System.out.println(responsavel1.getId());
		System.out.println(responsavel2.getId());

		// erro tá aqui!
		EquipeResponsavel equipeResponsavel = new EquipeResponsavel();
		equipeResponsavel.adicionaMembro(responsavel1);
		equipeResponsavel.adicionaMembro(responsavel2);
		
		// erro tá aqui!
		EquipeOrganizadora equipeOrganizadora = new EquipeOrganizadora();
		equipeOrganizadora.adicionaMembro(usuario1);
		equipeOrganizadora.adicionaMembro(usuario2);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
	}
}

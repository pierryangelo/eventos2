package codes.wise.eventos.modelo.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.atividade.TipoDeAtividade;
import codes.wise.eventos.modelo.dao.AtividadeDAO;
import codes.wise.eventos.modelo.dao.EquipeResponsavelDAO;
import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.usuario.EquipeResponsavel;

public class Teste {
	public static void main(String[] args) throws MembroJaExisteNaListaDeMembros{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");
		EntityManager em = emf.createEntityManager();
		
		EquipeResponsavelDAO equipeDao = new EquipeResponsavelDAO(em);
		AtividadeDAO atividadeDao = new AtividadeDAO(em);

		EquipeResponsavel eq = new EquipeResponsavel();
		
		Atividade at = new AtividadeBuilder()
				.comNome("CursoJPA")
				.comValor(new BigDecimal(100))
				.deTipo(TipoDeAtividade.PALESTRA)
				.comEquipeResponsavel(eq)
				.getAtividade();
		
		//eq.adicionaMembro(new Responsavel(new Pessoa("Pierry"), "Posgraduado"));
		em.getTransaction().begin();
		equipeDao.adiciona(eq);
		atividadeDao.adiciona(at);
		em.getTransaction().commit();
		em.close();
	}
}

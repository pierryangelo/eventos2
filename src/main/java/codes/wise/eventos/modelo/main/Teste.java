package codes.wise.eventos.modelo.main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.dao.DAOGenerico;
import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.usuario.EquipeResponsavel;
import codes.wise.eventos.modelo.usuario.Pessoa;
import codes.wise.eventos.modelo.usuario.Responsavel;

public class Teste {
	public static void main(String[] args) throws MembroJaExisteNaListaDeMembros{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");
		EntityManager em = emf.createEntityManager();
		
		DAOGenerico<Atividade> dao = new DAOGenerico<Atividade>(Atividade.class);
		EquipeResponsavel eq = new EquipeResponsavel();
		
		Atividade at = new AtividadeBuilder().comNome("Minha Atividade").comValor(new BigDecimal("100.0")).comEquipeResponsavel(new EquipeResponsavel()).getAtividade();
		eq.adicionaMembro(new Responsavel(new Pessoa("Pierry"), "Posgraduado"));
		em.getTransaction().begin();
		dao.adiciona(at);
		em.getTransaction().commit();
		em.close();
	}
}

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
import codes.wise.eventos.modelo.dao.EspacoFisicoDAO;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisicoBuilder;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.usuario.EquipeResponsavel;

public class Teste {
	public static void main(String[] args) throws MembroJaExisteNaListaDeMembros, HorarioJaOcupadoPorOutraAtividadeException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");
		EntityManager em = emf.createEntityManager();
		
		EquipeResponsavelDAO equipeDao = new EquipeResponsavelDAO(em);
		AtividadeDAO atividadeDao = new AtividadeDAO(em);
		EspacoFisicoDAO espacoFisicoDao = new EspacoFisicoDAO(em);
		
		EquipeResponsavel eq = new EquipeResponsavel();
		EspacoFisico ef = new EspacoFisicoBuilder()
		.comCapacidade(30)
		.comDescricao("Sala de Eventos")
		.comEndereco("Rua das Tripas, 14")
		.deNome("Sala B")
		.getEspacoFisico();
		
		Atividade at = new AtividadeBuilder()
				.comNome("CursoJPA")
				.comValor(new BigDecimal(100))
				.deTipo(TipoDeAtividade.PALESTRA)
				.comEquipeResponsavel(eq)
				.noEspacoFisico(ef)
				.getAtividade();
		
		//eq.adicionaMembro(new Responsavel(new Pessoa("Pierry"), "Posgraduado"));
		em.getTransaction().begin();
		espacoFisicoDao.adiciona(ef);
		equipeDao.adiciona(eq);
		atividadeDao.adiciona(at);
		em.getTransaction().commit();
		em.close();
	}
}

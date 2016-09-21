package codes.wise.eventos.modelo.main;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.atividade.AtividadeBuilder;
import codes.wise.eventos.modelo.atividade.TipoDeAtividade;
import codes.wise.eventos.modelo.dao.AtividadeDAO;
import codes.wise.eventos.modelo.dao.EquipeOrganizadoraDAO;
import codes.wise.eventos.modelo.dao.EquipeResponsavelDAO;
import codes.wise.eventos.modelo.dao.EspacoFisicoDAO;
import codes.wise.eventos.modelo.dao.EventoDAO;
import codes.wise.eventos.modelo.dao.InscricaoDAO;
import codes.wise.eventos.modelo.dao.OrganizacaoDAO;
import codes.wise.eventos.modelo.dao.ParticipacaoDAO;
import codes.wise.eventos.modelo.dao.PessoaDAO;
import codes.wise.eventos.modelo.dao.ResponsavelDAO;
import codes.wise.eventos.modelo.dao.UsuarioDAO;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.espaco_fisico.EspacoFisicoBuilder;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.evento.EventoBuilder;
import codes.wise.eventos.modelo.evento.TipoDeEvento;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;
import codes.wise.eventos.modelo.excecoes.InscricaoJaExisteException;
import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.inscricao.Inscricao;
import codes.wise.eventos.modelo.usuario.EquipeOrganizadora;
import codes.wise.eventos.modelo.usuario.EquipeResponsavel;
import codes.wise.eventos.modelo.usuario.Organizacao;
import codes.wise.eventos.modelo.usuario.Participacao;
import codes.wise.eventos.modelo.usuario.Pessoa;
import codes.wise.eventos.modelo.usuario.Responsavel;
import codes.wise.eventos.modelo.usuario.TipoDeParticipante;
import codes.wise.eventos.modelo.usuario.Usuario;
import codes.wise.eventos.modelo.usuario.UsuarioBuilder;

public class Teste {
	public static void main(String[] args) throws MembroJaExisteNaListaDeMembros, HorarioJaOcupadoPorOutraAtividadeException, InscricaoJaExisteException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventos");
		EntityManager em = emf.createEntityManager();
		
		EquipeResponsavelDAO equipeResponsavelDao = new EquipeResponsavelDAO(em);
		EquipeOrganizadoraDAO equipeOrganizadoraDao = new EquipeOrganizadoraDAO(em);
		AtividadeDAO atividadeDao = new AtividadeDAO(em);
		EspacoFisicoDAO espacoFisicoDao = new EspacoFisicoDAO(em);
		PessoaDAO pessoaDAO = new PessoaDAO(em);
		ResponsavelDAO responsavelDAO = new ResponsavelDAO(em);
		UsuarioDAO usuarioDao = new UsuarioDAO(em);
		EventoDAO eventoDao = new EventoDAO(em);
		ParticipacaoDAO participacaoDao = new ParticipacaoDAO(em);
		InscricaoDAO inscricaoDao = new InscricaoDAO(em);
		OrganizacaoDAO organizacaoDao = new OrganizacaoDAO(em);
		
		Evento evento = new EventoBuilder()
				.comNome("INFOTECH")
				.comDescricao("Semana de Tecnologia do IFPI")
				.comInicio(LocalDateTime.of(2016, 11, 1, 8, 0))
				.comTermino(LocalDateTime.of(2016, 11, 10, 17, 0))
				.deTipo(TipoDeEvento.SEMANA_CULTURAL)
				.getEvento();
		
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
		
		Participacao participacao = new Participacao(TipoDeParticipante.ESTUDANTE, usuario1);
		Inscricao inscricao = new Inscricao(evento, participacao);
		evento.adicionarInscricao(inscricao);
		
		Responsavel responsavel1 = new Responsavel(usuario1, "Curriculo");
		Responsavel responsavel2 = new Responsavel(usuario2, "Curriculo");
	
		EquipeResponsavel equipeResponsavel = new EquipeResponsavel();
		equipeResponsavel.adicionaMembro(responsavel1);
		equipeResponsavel.adicionaMembro(responsavel2);
		
		EquipeOrganizadora equipeOrganizadora = new EquipeOrganizadora();
		equipeOrganizadora.adicionaMembro(usuario1);
		equipeOrganizadora.adicionaMembro(usuario2);
		
		Organizacao organizacao = new Organizacao();
		organizacao.setEquipeOrganizadora(equipeOrganizadora);
		organizacao.setEvento(evento);
		organizacao.setUsuario(usuario1);
		
		EspacoFisico espacoFisico = new EspacoFisicoBuilder()
		.comCapacidade(30)
		.comDescricao("Sala de Eventos")
		.comEndereco("Rua das Tripas, 14")
		.deNome("Sala B")
		.getEspacoFisico();
		
		Atividade atividade = new AtividadeBuilder()
				.comNome("CursoJPA")
				.comValor(new BigDecimal(100))
				.deTipo(TipoDeAtividade.PALESTRA)
				.comEquipeResponsavel(equipeResponsavel)
				.noEspacoFisico(espacoFisico)
				.getAtividade();
		
		em.getTransaction().begin();
		eventoDao.adiciona(evento);
		usuarioDao.adiciona(usuario1);
		usuarioDao.adiciona(usuario2);
		responsavelDAO.adiciona(responsavel1);
		responsavelDAO.adiciona(responsavel2);

		participacaoDao.adiciona(participacao);
		pessoaDAO.adiciona(pessoa1);
		pessoaDAO.adiciona(pessoa2);
		equipeOrganizadoraDao.adiciona(equipeOrganizadora);
		equipeResponsavelDao.adiciona(equipeResponsavel);
		organizacaoDao.adiciona(organizacao);
		inscricaoDao.adiciona(inscricao);
		espacoFisicoDao.adiciona(espacoFisico);
		atividadeDao.adiciona(atividade);
		em.getTransaction().commit();
		em.close();
		

	}
}

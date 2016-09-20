package codes.wise.eventos.modelo.espaco_fisico;

import static codes.wise.eventos.modelo.util.TimeUtil.verificaConflitoDeHorarios;
import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.javadocmd.simplelatlng.LatLng;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException;
import codes.wise.eventos.modelo.excecoes.EspacosFisicosComLocalizacoesIguaisException;
import codes.wise.eventos.modelo.excecoes.HorarioJaOcupadoPorOutraAtividadeException;;

@Entity
public class EspacoFisico {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private EspacoFisico espacoFisicoPai;
	@OneToOne
	private Evento evento;
	private String nome;
	private String endereco;
	private String descricao;
	private LatLng localizacao;
	@OneToOne(mappedBy="espacoFisico")
	private Atividade atividade;
	private Integer capacidade;
	@Enumerated(EnumType.STRING)
	private TipoDeEspacoFisico tipoDeEspacoFisico;
	@OneToMany(mappedBy="espacoFisicoPai")
	private List<EspacoFisico> espacosFisicosFilhos;
	@ElementCollection
	private List<Horario> horarios;

	public EspacoFisico() {
		this.horarios = Lists.newArrayList();
		this.espacosFisicosFilhos = Lists.newArrayList();
	}

	public void setAtividade(Atividade atividade) 
			throws HorarioJaOcupadoPorOutraAtividadeException {
		if (!this.isHorarioDisponivel(atividade.getInicio(), atividade.getTermino())) {
			throw new HorarioJaOcupadoPorOutraAtividadeException();
		}
		this.atividade = atividade;
	}
	
	public void adicionaEspacoFisico(EspacoFisico espacoFisico) throws 
			EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException, 
			EspacosFisicosComLocalizacoesIguaisException {
		checkNotNull(espacoFisico);
		// to do: implementar hashCode
		if (espacoFisico.equals(espacoFisicoPai)) {
			throw new EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException();
		}
		if (espacoFisico.localizacao.equals(espacoFisico.localizacao)) {
			throw new EspacosFisicosComLocalizacoesIguaisException();
		}
		this.espacosFisicosFilhos.add(espacoFisico);
	}
	
	public boolean isHorarioDisponivel(LocalDateTime inicio, LocalDateTime termino) {
		for (Horario horario : this.horarios) {
			if (verificaConflitoDeHorarios(horario.getInicio(), horario.getTermino(), inicio, termino)) {
				return false;
			}
		}
		return true;
	}
	
	public EspacoFisico getEspacoFisicoPai() {
		return espacoFisicoPai;
	}
	
	public void setEspacoFisicoPai(EspacoFisico espacoFisicoPai) {
		this.espacoFisicoPai = espacoFisicoPai;
	}
	
	public LatLng getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(LatLng localizacao) {
		this.localizacao = localizacao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoDeEspacoFisico getTipoDeEspacoFisico() {
		return tipoDeEspacoFisico;
	}
	
	public void setTipoDeEspacoFisico(TipoDeEspacoFisico tipoDeEspacoFisico) {
		this.tipoDeEspacoFisico = tipoDeEspacoFisico;
	}
	
	public List<EspacoFisico> getEspacosFisicosFilhos() {
		return ImmutableList.copyOf(espacosFisicosFilhos);
	}
	
	public void setEspacosFisicosFilhos(List<EspacoFisico> espacosFisicosFilhos) {
		this.espacosFisicosFilhos = espacosFisicosFilhos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Atividade getAtividade() {
		return atividade;
	}
}

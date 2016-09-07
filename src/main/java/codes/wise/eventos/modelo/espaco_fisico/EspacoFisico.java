package codes.wise.eventos.modelo.espaco_fisico;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.javadocmd.simplelatlng.LatLng;

import codes.wise.eventos.excecoes.EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException;
import codes.wise.eventos.excecoes.EspacosFisicosComLocalizacoesIguaisException;
import codes.wise.eventos.modelo.atividade.Atividade;

public class EspacoFisico {
	private Integer id;
	private EspacoFisico espacoFisicoPai;
	private LatLng localizacao;
	private String endereco;
	private String descricao;
	private TipoDeEspacoFisico tipoDeEspacoFisico;
	private List<Atividade> atividades;
	private List<EspacoFisico> espacosFisicosFilhos;

	public EspacoFisico() {
		atividades = Lists.newArrayList();
		espacosFisicosFilhos = Lists.newArrayList();
	}
	
	public void adicionaEspacoFisico(EspacoFisico espacoFisico) throws 
			EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException, 
			EspacosFisicosComLocalizacoesIguaisException {
		
		checkNotNull(espacoFisico);
		
		if (espacoFisico.equals(espacoFisicoPai)) {
			throw new EspacoFisicoPaiNaoPodeEstarContidoEmEspacoFisicoFilhoException();
		}
		
		if (espacoFisico.localizacao.equals(espacoFisico.localizacao)) {
			throw new EspacosFisicosComLocalizacoesIguaisException();
		}
		
		espacosFisicosFilhos.add(espacoFisico);
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
	
	public List<Atividade> getAtividades() {
		return atividades;
	}
	
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
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
}

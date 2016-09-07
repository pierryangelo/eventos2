package codes.wise.eventos.modelo.espaco_fisico;

import java.util.List;

import com.javadocmd.simplelatlng.LatLng;

import codes.wise.eventos.modelo.atividade.Atividade;

public class EspacoFisico {
	private EspacoFisico espacoFisicoPai;
	private LatLng localizacao;
	private String endereco;
	private TipoDeEspacoFisico tipoDeEspacoFisico;
	private List<Atividade> atividades;
	private List<EspacoFisico> espacosFisicosFilhos;
	
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
		return espacosFisicosFilhos;
	}
	
	public void setEspacosFisicosFilhos(List<EspacoFisico> espacosFisicosFilhos) {
		this.espacosFisicosFilhos = espacosFisicosFilhos;
	}
	
	private String descricao;
}

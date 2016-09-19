package codes.wise.eventos.modelo.espaco_fisico;

import com.javadocmd.simplelatlng.LatLng;

public class EspacoFisicoBuilder {
	private EspacoFisico espacoFisico;
	
	public EspacoFisicoBuilder() {
		this.espacoFisico = new EspacoFisico();
	}
	
	public EspacoFisicoBuilder deNome(String nome) {
		this.espacoFisico.setNome(nome);
		return this;
	}
	
	public EspacoFisicoBuilder comEndereco(String endereco) {
		this.espacoFisico.setNome(endereco);
		return this;
	}
	
	public EspacoFisicoBuilder comDescricao(String descricao) {
		this.espacoFisico.setNome(descricao);
		return this;
	}
	
	public EspacoFisicoBuilder deTipo(TipoDeEspacoFisico tipoDeEspacoFisico) {
		this.espacoFisico.setTipoDeEspacoFisico(tipoDeEspacoFisico);
		return this;
	}
	
	public EspacoFisicoBuilder comCapacidade(Integer capacidade) {
		this.espacoFisico.setCapacidade(capacidade);
		return this;
	}
	
	public EspacoFisicoBuilder deLocalizacao(LatLng localizacao) {
		this.espacoFisico.setLocalizacao(localizacao);
		return this;
	}
	
	public EspacoFisico getEspacoFisico() {
		return this.espacoFisico;
	}
	
}

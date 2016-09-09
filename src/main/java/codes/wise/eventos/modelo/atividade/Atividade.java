package codes.wise.eventos.modelo.atividade;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import codes.wise.eventos.modelo.espaco_fisico.EspacoFisico;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.util.BigDecimalUtil;

public class Atividade {
	private Integer id;
	private Evento evento;
	private String nome;
	private LocalDateTime dataEHoraDeInicio;
	private LocalDateTime dataEHoraDeTermino;
	private EspacoFisico espacoFisico;
	private TipoDeAtividade tipoDeAtividade;
	private BigDecimal valor;
	private Boolean isPaga;
	
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDateTime getDataEHoraDeInicio() {
		return dataEHoraDeInicio;
	}
	
	public void setDataEHoraDeInicio(LocalDateTime dataEHoraDeInicio) {
		this.dataEHoraDeInicio = dataEHoraDeInicio;
	}
	
	public LocalDateTime getDataEHoraDeTermino() {
		return dataEHoraDeTermino;
	}
	
	public void setDataEHoraDeTermino(LocalDateTime dataEHoraDeTermino) {
		this.dataEHoraDeTermino = dataEHoraDeTermino;
	}
	
	public EspacoFisico getEspacoFisico() {
		return espacoFisico;
	}
	
	public void setEspacoFisico(EspacoFisico espacoFisico) {
		this.espacoFisico = espacoFisico;
	}
	
	public TipoDeAtividade getTipoDeAtividade() {
		return tipoDeAtividade;
	}
	
	public void setTipoDeAtividade(TipoDeAtividade tipoDeAtividade) {
		this.tipoDeAtividade = tipoDeAtividade;
	}
	
	public Boolean getIsPaga() {
		return isPaga;
	}
	
	public void setIsPaga(Boolean isPaga) {
		this.isPaga = isPaga;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = BigDecimalUtil.paraMonetario(this.valor);
	}
	
	public BigDecimal getValor() {
		return BigDecimalUtil.paraMonetario(this.valor);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

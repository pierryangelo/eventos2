package codes.wise.eventos.modelo.cupom;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CupomPorAtividade extends Cupom {
	@OneToOne
	private Atividade atividade;
	
	protected CupomPorAtividade(BigDecimal porcentagemDoDesconto, Evento evento, Atividade atividade) {
		super(porcentagemDoDesconto);
		this.evento = evento;
		this.atividade = atividade;
	}

	@Override
	public Boolean isAtivo() {
		return evento.getAtividades().contains(this.atividade);
	}
}

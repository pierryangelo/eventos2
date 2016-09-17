package codes.wise.eventos.modelo.cupom;

import java.math.BigDecimal;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;

public class CupomPorAtividade extends Cupom {
	private Evento evento;
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

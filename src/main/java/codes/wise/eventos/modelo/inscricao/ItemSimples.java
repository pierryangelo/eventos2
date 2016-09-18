package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;

public class ItemSimples extends Item {
	private Atividade atividade;
	private Evento evento;
	
	public ItemSimples(BigDecimal preco, Atividade atividade, Evento evento) 
			throws NaoExisteAtividadeNaListaDeAtividadesDoEventoException {
		super(preco);
		if (!existeAtividadeNoEvento()) {
			throw new NaoExisteAtividadeNaListaDeAtividadesDoEventoException();
		}
		this.atividade = atividade;
		this.evento = evento;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	private boolean existeAtividadeNoEvento() {
		return evento.getAtividades().contains(atividade);
	}
}

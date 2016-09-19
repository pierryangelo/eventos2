package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
@Entity
@PrimaryKeyJoinColumn(name="id")
public class ItemSimples extends Item {
	@OneToOne
	private Atividade atividade;
	@OneToOne
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

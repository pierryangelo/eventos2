package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
@Entity
@PrimaryKeyJoinColumn(name="id")
public class ItemSimples extends Item {
	@OneToOne
	private Atividade atividade;

	public ItemSimples(BigDecimal preco, Atividade atividade) 
			throws NaoExisteAtividadeNaListaDeAtividadesDoEventoException, 
			AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException {
		super(preco);
		if (!existeAtividadeNoEvento(atividade.getEvento())) {
			throw new NaoExisteAtividadeNaListaDeAtividadesDoEventoException();
		}
		if (!atividade.isPaga()) {
			throw new AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException();
		}
		this.atividade = atividade;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	private boolean existeAtividadeNoEvento(Evento evento) {
		return evento.getAtividades().contains(atividade);
	}
}

package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import codes.wise.eventos.modelo.atividade.Atividade;
import codes.wise.eventos.modelo.evento.Evento;
import codes.wise.eventos.modelo.excecoes.AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException;
import codes.wise.eventos.modelo.excecoes.NaoExisteAtividadeNaListaDeAtividadesDoEventoException;
@Entity
@DiscriminatorValue("S")
public class ItemSimples extends Item {
	@OneToOne
	private Atividade atividade;

	public ItemSimples(Atividade atividade, Inscricao inscricao) 
			throws NaoExisteAtividadeNaListaDeAtividadesDoEventoException, 
			AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException {
		atividadePertenceAoEventoDaInscricao(inscricao.getEvento(), atividade);
		isAtividadePaga(atividade);
		this.atividade = atividade;
		this.inscricao = inscricao;
	}

	private void isAtividadePaga(Atividade atividade) 
			throws AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException {
		if (!atividade.isPaga()) {
			throw new AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException();
		}
	}
	
	private void atividadePertenceAoEventoDaInscricao(Evento evento, Atividade atividade) 
			throws NaoExisteAtividadeNaListaDeAtividadesDoEventoException {
		if (!evento.getAtividades().contains(atividade)) {
			throw new NaoExisteAtividadeNaListaDeAtividadesDoEventoException();
		}
	}

	public void setAtividade(Atividade atividade) 
			throws AtividadeNaoPagaNaoPodeSerUmItemDeInscricaoException, 
			NaoExisteAtividadeNaListaDeAtividadesDoEventoException {
		isAtividadePaga(atividade);
		atividadePertenceAoEventoDaInscricao(this.inscricao.getEvento(), atividade);
		this.atividade = atividade;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public String getDescricao() {
		return this.atividade.getNome();
	}

	@Override
	public BigDecimal getPreco() {
		return atividade.getValor();
	}
	
	@Override
	public String toString() {
		return this.getDescricao();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((atividade == null) ? 0 : atividade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemSimples other = (ItemSimples) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		return true;
	}
}

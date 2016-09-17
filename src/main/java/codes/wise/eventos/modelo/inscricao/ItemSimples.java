package codes.wise.eventos.modelo.inscricao;

import java.math.BigDecimal;

import codes.wise.eventos.modelo.atividade.Atividade;

public class ItemSimples extends Item {
	private Atividade atividade;
	
	public ItemSimples(BigDecimal preco, Atividade atividade) {
		super(preco);
		this.atividade = atividade;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
}

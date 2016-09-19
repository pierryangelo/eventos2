package codes.wise.eventos.modelo.inscricao;

import java.util.List;

import codes.wise.eventos.modelo.cupom.Cupom;
import codes.wise.eventos.modelo.evento.Evento;

public class InscricaoBuilder {
	private Inscricao inscricao;
	
	public InscricaoBuilder() {
		this.inscricao = new Inscricao();
	}
	
	public InscricaoBuilder doEvento(Evento evento) {
		this.inscricao.setEvento(evento);
		return this;
	}
	
	public InscricaoBuilder comItens(List<Item> itens) {
		this.inscricao.setCarrinho(itens);
		return this;
	}
	
	public InscricaoBuilder comCupons(List<Cupom> cupons) {
		this.inscricao.setCupons(cupons);
		return this;
	}
}

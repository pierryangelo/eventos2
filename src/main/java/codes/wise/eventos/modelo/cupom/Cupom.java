package codes.wise.eventos.modelo.cupom;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import codes.wise.eventos.modelo.evento.Evento;

@Entity
public abstract class Cupom implements Descontavel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	@OneToOne
	protected Evento evento;
	protected Boolean isAtivo;
	protected BigDecimal porcentagemDoDesconto;
	
	protected Cupom(BigDecimal porcentagemDoDesconto) {
		this.porcentagemDoDesconto = porcentagemDoDesconto;
	}
	
	public abstract Boolean isAtivo();

	public BigDecimal getPorcentagemDoDesconto() {
		return this.porcentagemDoDesconto;
	}
}

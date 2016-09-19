package codes.wise.eventos.modelo.usuario;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class EquipeResponsavel extends Equipe<Responsavel> {
}

package codes.wise.eventos.modelo.usuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class EquipeResponsavel extends Equipe<Responsavel> {}

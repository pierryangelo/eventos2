package codes.wise.eventos.modelo.usuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class EquipeOrganizadora extends Equipe<Usuario> {}
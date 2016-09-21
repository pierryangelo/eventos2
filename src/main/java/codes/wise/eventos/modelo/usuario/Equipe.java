package codes.wise.eventos.modelo.usuario;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.excecoes.MembroNaoExisteNaListaDeMembrosException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaAdicionadoAEquipeException;
import codes.wise.eventos.modelo.excecoes.UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Equipe<E> implements Time<E> {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@OneToMany
	private List<E> membros;
	@OneToOne
	private E principal;
	
	public Equipe() {
		this.membros = Lists.newArrayList();
	}
	/**
	 * Adiciona membros à equipe. O primeiro membro é automaticamente definido 
	 * como principal.
	 * @param usuario
	 * @throws UsuarioJaAdicionadoAEquipeException
	 */
	@Override
	public void adicionaMembro(E membro) 
			throws MembroJaExisteNaListaDeMembros {
		if (membros.contains(membro)) {
			throw new MembroJaExisteNaListaDeMembros();
		}
		if (this.principal == null) {
			this.principal = membro;
		}
		this.membros.add(membro);
	}
	
	/**
	 * Define o membro principal da equipe. O membro principal precisa estar na 
	 * lista de membros da equipe.
	 * @param usuario
	 * @throws UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException
	 */
	@Override
	public void definePrincipal(E membro) 
			throws MembroNaoExisteNaListaDeMembrosException {
		if (!membros.contains(membro)) {
			throw new MembroNaoExisteNaListaDeMembrosException();
		}
		principal = membro;
	}
	
	@Override
	public E getPrincipal() {
		return this.principal;
	}
	
	@Override
	public List<E> getMembros() {
		return ImmutableList.copyOf(membros);
	}
}

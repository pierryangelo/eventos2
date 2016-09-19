package codes.wise.eventos.modelo.usuario;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.google.common.collect.ImmutableList;

import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.excecoes.MembroNaoExisteNaListaDeMembrosException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaAdicionadoAEquipeException;
import codes.wise.eventos.modelo.excecoes.UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipe<E> implements Time<E> {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ElementCollection
	private List<E> membros;
	@OneToOne
	private E principal;
	
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

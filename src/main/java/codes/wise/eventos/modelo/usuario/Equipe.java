package codes.wise.eventos.modelo.usuario;

import java.util.List;

import com.google.common.collect.ImmutableList;

import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.excecoes.MembroNaoExisteNaListaDeMembrosException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaAdicionadoAEquipeException;
import codes.wise.eventos.modelo.excecoes.UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException;

public abstract class Equipe<E> implements Time<E> {
	private List<E> membros;
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

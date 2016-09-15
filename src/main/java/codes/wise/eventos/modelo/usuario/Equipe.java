package codes.wise.eventos.modelo.usuario;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.excecoes.UsuarioJaAdicionadoAEquipeException;
import codes.wise.eventos.excecoes.UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException;

public class Equipe {
	List<Usuario> usuarios;
	Usuario principal;
	
	public Equipe() {
		this.usuarios = Lists.newArrayList();
	}
	
	/**
	 * Adiciona usuários à equipe. O primeiro usuário é automaticamente definido 
	 * como usuário principal.
	 * @param usuario
	 * @throws UsuarioJaAdicionadoAEquipeException
	 */
	public void adicionaUsuario(Usuario usuario) 
			throws UsuarioJaAdicionadoAEquipeException {
		if (usuarios.contains(usuario)) {
			throw new UsuarioJaAdicionadoAEquipeException();
		}
		
		if (principal == null) {
			principal = usuario;
		}
		
		usuarios.add(usuario);
	}
	
	/**
	 * Define o usuário principal da equipe. Usuário principal precisa estar na lista de usuários
	 * da equipe.
	 * @param usuario
	 * @throws UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException
	 */
	public void setPrincipal(Usuario usuario) 
			throws UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException {
		if (!usuarios.contains(usuario)) {
			throw new UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException();
		}
		this.principal = usuario;
	}
	
	public List<Usuario> getUsuarios() {
		return ImmutableList.copyOf(usuarios);
	}
}

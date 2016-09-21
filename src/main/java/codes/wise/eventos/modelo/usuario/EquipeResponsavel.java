package codes.wise.eventos.modelo.usuario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.excecoes.MembroNaoExisteNaListaDeMembrosException;
import codes.wise.eventos.modelo.excecoes.UsuarioJaAdicionadoAEquipeException;
import codes.wise.eventos.modelo.excecoes.UsuarioPrincipalPrecisarEstarNaListaDeUsuariosException;

@Entity
public class EquipeResponsavel {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany
	private List<Responsavel> membros;
	@OneToOne
	private Responsavel principal;
	
	public EquipeResponsavel() {
		this.membros = Lists.newArrayList();
	}
	/**
	 * Adiciona membros à equipe. O primeiro membro é automaticamente definido 
	 * como principal.
	 * @param usuario
	 * @throws UsuarioJaAdicionadoAEquipeException
	 */
	public void adicionaMembro(Responsavel membro) 
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
	public void definePrincipal(Responsavel membro) 
			throws MembroNaoExisteNaListaDeMembrosException {
		if (!membros.contains(membro)) {
			throw new MembroNaoExisteNaListaDeMembrosException();
		}
		principal = membro;
	}
	
	public Responsavel getPrincipal() {
		return this.principal;
	}
	
	public List<Responsavel> getMembros() {
		return ImmutableList.copyOf(membros);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
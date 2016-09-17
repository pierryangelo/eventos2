package codes.wise.eventos.modelo.usuario;

import java.util.List;

import codes.wise.eventos.modelo.excecoes.MembroJaExisteNaListaDeMembros;
import codes.wise.eventos.modelo.excecoes.MembroNaoExisteNaListaDeMembrosException;

public interface Time<E> {
	void adicionaMembro(E membro) throws MembroJaExisteNaListaDeMembros;
	void definePrincipal(E membro) throws MembroNaoExisteNaListaDeMembrosException;
	E getPrincipal();
	List<E> getMembros();
}

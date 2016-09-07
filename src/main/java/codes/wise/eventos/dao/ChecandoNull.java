package codes.wise.eventos.dao;

import com.google.common.base.Preconditions;

public class ChecandoNull {
	public void teste(String novo) {
		Preconditions.checkNotNull(novo, "Elemento nulo!");
	}
}

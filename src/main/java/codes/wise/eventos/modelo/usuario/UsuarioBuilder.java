package codes.wise.eventos.modelo.usuario;

import java.time.LocalDateTime;

public class UsuarioBuilder {
	private Usuario usuario;
	public UsuarioBuilder() {
		this.usuario = usuario;
	}
	
	public UsuarioBuilder comDataDeCadastro(LocalDateTime dataCadastro) {
		this.usuario.setDataCadastro(dataCadastro);
		return this;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
}

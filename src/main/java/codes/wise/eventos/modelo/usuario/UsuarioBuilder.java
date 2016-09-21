package codes.wise.eventos.modelo.usuario;

import java.time.LocalDateTime;

public class UsuarioBuilder {
	private Usuario usuario;
	
	public UsuarioBuilder() {
		this.usuario = new Usuario();
	}
	
	public UsuarioBuilder comDataDeCadastro(LocalDateTime dataCadastro) {
		this.usuario.setDataCadastro(dataCadastro);
		return this;
	}
	 public UsuarioBuilder infoPessoais(Pessoa pessoa) {
		 this.usuario.setPessoa(pessoa);
		 return this;
	 }
	
	public UsuarioBuilder comEmail(String email) {
		this.usuario.setEmail(email);
		return this;
	}
	
	public UsuarioBuilder comSenha(String senha) {
		this.usuario.setPassword(senha);
		return this;
	}
	
	public UsuarioBuilder ativo(boolean ativo) {
		this.usuario.setIsAtivo(ativo);
		return this;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
}

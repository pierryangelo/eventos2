package codes.wise.eventos.modelo.usuario;

import java.time.LocalDate;

public class PessoaBuilder {
	private Pessoa pessoa;
	
	public PessoaBuilder() {
		this.pessoa = new Pessoa();
	}
	
	public PessoaBuilder comNome(String nome) {
		this.pessoa.setNome(nome);
		return this;
	}
	
	public PessoaBuilder comCPF(String cpf) {
		this.pessoa.setCpf(cpf);
		return this;
	}
	
	public PessoaBuilder comEndereco(String endereco) {
		this.pessoa.setEndereco(endereco);
		return this;
	}
	
	public PessoaBuilder comDataDeNascimento(LocalDate dataNascimento) {
		this.pessoa.setDataNascimento(dataNascimento);
		return this;
	}
	
	public PessoaBuilder comTelefone(String telefone) {
		this.pessoa.setTelefone(telefone);
		return this;
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
}

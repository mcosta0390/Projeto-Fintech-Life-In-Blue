package br.com.fiap.bean;

import java.util.Calendar;

public class CadastroUsuario {

	private int codigo;

	private String nome;

	private Calendar nascimento;

	private String genero;

	private String email;

	private String senha;

	public CadastroUsuario(int codigo, String nome, Calendar nascimento, String genero, String email, String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
		this.email = email;
		this.senha = senha;
	}

	public CadastroUsuario() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Calendar getData() {
		return null;
	}

}

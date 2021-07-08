package com.andredev.Projeto.Unidos.Pra.Cachorro.dto;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Usuario;

public class UsuarioDTO {
		
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cargo;
		
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email, String senha, String cargo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
	}

	public UsuarioDTO(Usuario entidade) {
		id = entidade.getId();
		nome = entidade.getNome();
		email = entidade.getEmail();
		senha = entidade.getSenha();
		cargo = entidade.getCargo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}

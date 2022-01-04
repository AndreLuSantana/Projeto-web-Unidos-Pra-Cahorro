package com.andredev.Projeto.Unidos.Pra.Cachorro.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Adotante;

public class AdotanteDTO {

private Long id;
	
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private int telefone;
	private Set<AnimalDTO> adotado = new HashSet<>();

	public AdotanteDTO() {
		
	}

	public AdotanteDTO(Long id, String nome, String email, LocalDate dataNascimento, int telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	public AdotanteDTO(Adotante entidade) {
		id = entidade.getId();
		nome = entidade.getNome();
		email = entidade.getEmail();
		dataNascimento = entidade.getDataNascimento();
		telefone = entidade.getTelefone();
		
		adotado = entidade.getAdotado().stream().map(x-> new AnimalDTO(x)).collect(Collectors.toSet());
		}

	public AdotanteDTO(Optional<Adotante> adotante) {
		
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Set<AnimalDTO> getAdotado() {
		return adotado;
	}
}

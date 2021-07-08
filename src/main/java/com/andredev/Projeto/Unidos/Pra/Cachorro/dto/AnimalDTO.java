package com.andredev.Projeto.Unidos.Pra.Cachorro.dto;

import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Adotante;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;
import com.andredev.Projeto.Unidos.Pra.Cachorro.enuns.Opcoes;

public class AnimalDTO {

private Long id;
	
	private String identificador;
	private Opcoes vacinado;
	private Opcoes castrado;
	private Opcoes retornadoParaRua;
	private Adotante adotante;
	
	public AnimalDTO() {
	}

	public AnimalDTO(Long id, String identificador, Opcoes vacinado, Opcoes castrado, Opcoes retornadoParaRua,
			Adotante adotante) {
		this.id = id;
		this.identificador = identificador;
		this.vacinado = vacinado;
		this.castrado = castrado;
		this.retornadoParaRua = retornadoParaRua;
		this.adotante = adotante;
	}
	
	public AnimalDTO(Animal entidade) {
		
		id = entidade.getId();
		identificador = entidade.getIdentificador();
		vacinado = entidade.getVacinado();
		castrado = entidade.getCastrado();
		retornadoParaRua = entidade.getRetornadoParaRua();
		adotante = entidade.getAdotante();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Opcoes getVacinado() {
		return vacinado;
	}

	public void setVacinado(Opcoes vacinado) {
		this.vacinado = vacinado;
	}

	public Opcoes getCastrado() {
		return castrado;
	}

	public void setCastrado(Opcoes castrado) {
		this.castrado = castrado;
	}

	public Opcoes getRetornadoParaRua() {
		return retornadoParaRua;
	}

	public void setRetornadoParaRua(Opcoes retornadoParaRua) {
		this.retornadoParaRua = retornadoParaRua;
	}

	public Adotante getAdotante() {
		return adotante;
	}

	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
}

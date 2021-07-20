package com.andredev.Projeto.Unidos.Pra.Cachorro.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andredev.Projeto.Unidos.Pra.Cachorro.enuns.Opcoes;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String identificador;
	@Enumerated
	private Opcoes vacinado;
	@Enumerated
	private Opcoes castrado;
	@Enumerated
	private Opcoes retornadoParaRua;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_adotante")
	private Adotante adotante;
	
	public Animal() {
	}

	public Animal(Long id, String identificador, Opcoes vacinado, Opcoes castrado, Opcoes retornadoParaRua) {
		this.id = id;
		this.identificador = identificador;
		this.vacinado = vacinado;
		this.castrado = castrado;
		this.retornadoParaRua = retornadoParaRua;
	}
	
	public Animal(Long id, String identificador, Opcoes vacinado, Opcoes castrado, Opcoes retornadoParaRua, Adotante adotante) {
		this.id = id;
		this.identificador = identificador;
		this.vacinado = vacinado;
		this.castrado = castrado;
		this.retornadoParaRua = retornadoParaRua;
		this.adotante = adotante;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [identificador=" + identificador + ", vacinado=" + vacinado + ", castrado=" + castrado
				+ ", retornadoParaRua=" + retornadoParaRua + "]";
	}

}

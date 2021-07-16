package com.andredev.Projeto.Unidos.Pra.Cachorro.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.AnimalRepository;

@Entity
@Table(name = "tb_adotante")
public class Adotante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private int telefone;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="adotante_id")
	private List<Animal> adotado = new ArrayList<>();

	public Adotante() {
		
	}

	public Adotante(Long id, String nome, String email, LocalDate dataNascimento, int telefone, List<Animal> adotado) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.adotado = adotado;
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

	public List<Animal> getAdotado() {
		return adotado;
	}
	
	public void adicionarAnimal(Animal obj){ 
		Animal animal = new Animal(obj.getId(), obj.getIdentificador(), obj.getVacinado(), obj.getCastrado(), 
				obj.getRetornadoParaRua());
		this.adotado.add(animal);
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
		Adotante other = (Adotante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adotante [nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento + ", telefone="
				+ telefone + ", adotado=" + adotado + "]";
	}
	
	
}

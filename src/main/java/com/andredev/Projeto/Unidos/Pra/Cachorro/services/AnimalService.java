package com.andredev.Projeto.Unidos.Pra.Cachorro.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.AnimalRepository;

public class AnimalService {

	@Autowired
	private AnimalRepository repository;
	
	@Transactional
	public List<Animal> findAll(){
		return repository.findAll();
	}
	
}

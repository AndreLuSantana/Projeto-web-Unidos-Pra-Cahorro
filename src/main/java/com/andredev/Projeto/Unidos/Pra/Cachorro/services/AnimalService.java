package com.andredev.Projeto.Unidos.Pra.Cachorro.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AnimalDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Adotante;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.AnimalRepository;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.exceptions.ResourceNotFoundException;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;
	
	@Transactional(readOnly = true)
	public Set<AnimalDTO> findAll(){
		List <Animal> animais = repository.findAll();
		return animais.stream().map(x -> new AnimalDTO(x)).collect(Collectors.toSet());
	}
	
	@Transactional(readOnly = true)
	public Animal findById(Long id) {
		Optional<Animal> adotante = repository.findById(id);
		return adotante.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public AnimalDTO insert(Animal obj) {
		Animal animal = repository.save(obj);
		return new AnimalDTO(animal);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

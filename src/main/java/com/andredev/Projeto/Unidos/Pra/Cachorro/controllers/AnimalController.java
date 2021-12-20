package com.andredev.Projeto.Unidos.Pra.Cachorro.controllers;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AnimalDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.AnimalService;

@RestController
@RequestMapping(value="/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService service;

	@GetMapping
	public ResponseEntity<Set<AnimalDTO>> findAll(){
		Set<AnimalDTO> set = service.findAll();
		return ResponseEntity.ok().body(set);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDTO> findById(@PathVariable Long id){
		AnimalDTO animalDTO = service.findById(id);
		return ResponseEntity.ok().body(animalDTO);
	}
	
	@PostMapping
	public ResponseEntity<AnimalDTO> insert(@RequestBody Animal obj){
		AnimalDTO animal = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(animal);
	}
	
	@DeleteMapping("{/id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

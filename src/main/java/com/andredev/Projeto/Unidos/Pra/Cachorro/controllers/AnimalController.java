package com.andredev.Projeto.Unidos.Pra.Cachorro.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AnimalDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.AnimalService;

@RestController
@RequestMapping(value="/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService service;

	@GetMapping
	public ResponseEntity<Set<AnimalDTO>> findAll(){
		Set<AnimalDTO> animais = service.findAll();
		return ResponseEntity.ok().body(animais);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDTO> findById(@PathVariable Long id){
		AnimalDTO animalDTO = service.findById(id);
		return ResponseEntity.ok().body(animalDTO);
	}
}

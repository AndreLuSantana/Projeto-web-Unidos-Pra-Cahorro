package com.andredev.Projeto.Unidos.Pra.Cachorro.controllers;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AdotanteDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Adotante;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.AdotanteService;

@RestController
@RequestMapping(value = "/adotantes")
public class AdotanteController {

	@Autowired
	private AdotanteService service;
	
	@GetMapping
	public ResponseEntity<Set<AdotanteDTO>> findAll(){
		Set<AdotanteDTO> set = service.findAll();
		return ResponseEntity.ok().body(set);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Adotante> findById(@PathVariable Long id){
		Adotante adotante = service.findById(id);
		return ResponseEntity.ok().body(adotante);
	}
	
	@PostMapping
	public ResponseEntity<AdotanteDTO> insert(@RequestBody Adotante obj){
		AdotanteDTO adotante = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(adotante.getId()).toUri();
		return ResponseEntity.created(uri).body(adotante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<AdotanteDTO> update(@PathVariable Long id, @RequestBody AdotanteDTO obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}

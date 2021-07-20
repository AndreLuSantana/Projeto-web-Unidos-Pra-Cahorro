package com.andredev.Projeto.Unidos.Pra.Cachorro.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AdotanteDTO;
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
	public ResponseEntity<AdotanteDTO> findById(@PathVariable Long id){
		AdotanteDTO adotante = service.findById(id);
		return ResponseEntity.ok().body(adotante);
	}

}

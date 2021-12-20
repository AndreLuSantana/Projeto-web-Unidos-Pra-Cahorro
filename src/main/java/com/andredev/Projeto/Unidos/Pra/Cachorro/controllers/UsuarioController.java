package com.andredev.Projeto.Unidos.Pra.Cachorro.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.UsuarioDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	public UsuarioService service;

	@GetMapping
	public ResponseEntity<Set<UsuarioDTO>> findAll(){
		Set<UsuarioDTO> set = service.findAll();
		return ResponseEntity.ok().body(set);
	}
	
	@GetMapping("/{id}")
	 public ResponseEntity<UsuarioDTO> findByid(@PathVariable Long id){
		 UsuarioDTO usuarioDTO = service.findById(id);
		 return ResponseEntity.ok().body(usuarioDTO);
	 }
	
	
}

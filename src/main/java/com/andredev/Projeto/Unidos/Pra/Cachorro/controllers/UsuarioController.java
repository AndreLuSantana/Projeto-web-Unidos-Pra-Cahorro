package com.andredev.Projeto.Unidos.Pra.Cachorro.controllers;

import java.net.URI;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.UsuarioDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Usuario;
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
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> insert (@RequestBody Usuario obj){
		UsuarioDTO usuario = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
}

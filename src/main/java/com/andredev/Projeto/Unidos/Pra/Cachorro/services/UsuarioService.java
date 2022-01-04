package com.andredev.Projeto.Unidos.Pra.Cachorro.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AnimalDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.UsuarioDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Usuario;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.UsuarioRepository;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public Set<UsuarioDTO> findAll(){
		List<Usuario> usuarios = repository.findAll();
		return usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toSet());
	}
	
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		Optional<Usuario> adotante = repository.findById(id);
		return adotante.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public UsuarioDTO insert(Usuario obj) {
		Usuario usuario = repository.save(obj);
		return new UsuarioDTO(usuario);
	}
}

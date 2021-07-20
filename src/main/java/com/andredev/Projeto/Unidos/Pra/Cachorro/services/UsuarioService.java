package com.andredev.Projeto.Unidos.Pra.Cachorro.services;

import java.util.List;
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
	public UsuarioDTO findById(Long id) {
		Usuario usuario = repository.getById(id);
		return new UsuarioDTO(usuario);
	}
}

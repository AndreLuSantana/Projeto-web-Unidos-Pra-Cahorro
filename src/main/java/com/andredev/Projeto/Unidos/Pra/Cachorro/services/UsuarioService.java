package com.andredev.Projeto.Unidos.Pra.Cachorro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Usuario;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.UsuarioRepository;

public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
}

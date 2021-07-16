package com.andredev.Projeto.Unidos.Pra.Cachorro.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andredev.Projeto.Unidos.Pra.Cachorro.dto.AdotanteDTO;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Adotante;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.AdotanteRepository;

@Service
public class AdotanteService {

	@Autowired
	private AdotanteRepository repository;
	
	@Transactional(readOnly = true)
	public Set<AdotanteDTO> findAll(){
		List<Adotante> adotante = repository.findAll();
		return adotante.stream().map(x -> new AdotanteDTO(x)).collect(Collectors.toSet());
	}
	@Transactional(readOnly = true)
	public AdotanteDTO findById(Long id) {
		Adotante adotante = repository.getById(id);
		return new AdotanteDTO(adotante);
		
		
	}
}

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
	@Transactional()
	public AdotanteDTO insert(Adotante obj) {
		 Adotante adotante = repository.save(obj);
		 return new AdotanteDTO(adotante);
	}
	@Transactional()
	public void delete(Long id) {
		repository.deleteById(id); 
	}
	@Transactional()
	public AdotanteDTO update(Long id, AdotanteDTO obj ) {
		@SuppressWarnings("deprecation")
		Adotante adotante = repository.getOne(id);
		updatedata(adotante, obj);
		repository.save(adotante);
		return new AdotanteDTO(adotante);
	}
	@Transactional()
	private void updatedata(Adotante adotante, AdotanteDTO obj) {
		adotante.setNome(obj.getNome());
		adotante.setEmail(obj.getEmail());
		adotante.setDataNascimento(obj.getDataNascimento());
		adotante.setTelefone(obj.getTelefone());
		
	}
}

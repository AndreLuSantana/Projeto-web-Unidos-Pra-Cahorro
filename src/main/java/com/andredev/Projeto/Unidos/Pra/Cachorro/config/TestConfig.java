package com.andredev.Projeto.Unidos.Pra.Cachorro.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Adotante;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;
import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Usuario;
import com.andredev.Projeto.Unidos.Pra.Cachorro.enuns.Opcoes;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.AdotanteRepository;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.AnimalRepository;
import com.andredev.Projeto.Unidos.Pra.Cachorro.repositories.UsuarioRepository;
import com.andredev.Projeto.Unidos.Pra.Cachorro.services.AdotanteService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ // Tudo que estiver dentro do método run executa ao iniciar a execução

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AdotanteRepository adotanteRepository;
	@Autowired
	private AdotanteService adotanteService;
		
	@Override
	public void run(String... args) throws Exception {
		
		Animal animal1 = new Animal(null, "Totó", Opcoes.SIM, Opcoes.SIM, Opcoes.NAO);
		Animal animal2 = new Animal(null, "Bingo", Opcoes.SIM, Opcoes.NAO, Opcoes.SIM);
		Animal animal3 = new Animal(null, "Nina", Opcoes.SIM, Opcoes.NAO, Opcoes.SIM);
		
		Adotante adotante = new Adotante(null, "André", "andre@hotmail.com", LocalDate.now(), 5055, new ArrayList<>());
		adotante.adicionarAnimal(animal2);
		adotante.adicionarAnimal(animal1);
		Adotante adotante2 = new Adotante(null, "Zé", "ze@hotmail.com", LocalDate.now(), 5805, new ArrayList<>());
		adotante2.adicionarAnimal(animal3);
		
		Usuario usuario = new Usuario(null, "André", "andre@hotmail.com", "123", "Tesoureiro");
		
		animalRepository.saveAll(Arrays.asList(animal1, animal2, animal3));
		adotanteRepository.save(adotante);
		adotanteRepository.save(adotante2);
		usuarioRepository.save(usuario);
		
		
	}

	
}

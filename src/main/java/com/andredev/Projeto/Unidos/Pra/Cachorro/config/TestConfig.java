package com.andredev.Projeto.Unidos.Pra.Cachorro.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

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

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ // Tudo que estiver dentro do método run executa ao iniciar a execução

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AdotanteRepository adotanteRepository;
		
	@Override
	public void run(String... args) throws Exception {
		
		Animal animal1 = new Animal(null, "Totó", Opcoes.SIM, Opcoes.SIM, Opcoes.NAO, null);
		Animal animal2 = new Animal(null, "Nina", Opcoes.SIM, Opcoes.SIM, Opcoes.SIM, null);
		
		Adotante adotante = new Adotante(null, "André", "andre@hotmail.com", LocalDate.now(), 5055, new HashSet<>());
		adotante.adicionarAnimal(animal2);
		
		Usuario usuario = new Usuario(null, "André", "andre@hotmail.com", "123", "Tesoureiro");
		
		animalRepository.saveAll(Arrays.asList(animal1, animal2));
		adotanteRepository.save(adotante);
		usuarioRepository.save(usuario);
		
	}

	
}

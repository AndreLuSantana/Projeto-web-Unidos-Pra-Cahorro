package com.andredev.Projeto.Unidos.Pra.Cachorro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andredev.Projeto.Unidos.Pra.Cachorro.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}

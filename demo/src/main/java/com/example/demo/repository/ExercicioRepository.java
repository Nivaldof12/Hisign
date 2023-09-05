package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Exercicio;

@Repository
public interface ExercicioRepository extends CrudRepository<Exercicio, Integer> {

}

package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer> {

}

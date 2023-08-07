package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Teste;

@Repository
public interface TesteRepository extends CrudRepository<Teste, Integer> {

}

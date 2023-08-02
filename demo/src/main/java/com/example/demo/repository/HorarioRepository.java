package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demo.domain.Horario;

@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer> {
    @Query("SELECT h FROM Horario h ORDER BY h.nomecompleto")
    List<Horario> findAllOrderedByNomeCompleto();



}

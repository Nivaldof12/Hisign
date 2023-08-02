package com.example.demo.repository;

import com.example.demo.domain.HorarioGeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioGeralRepository extends JpaRepository<HorarioGeral, Integer> {
    @Query("SELECT h FROM HorarioGeral h ORDER BY h.nomecompleto")
    HorarioGeral findAllOrderedByNomeCompleto();
}

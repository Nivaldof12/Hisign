package com.example.demo.repository.diasdaSemana;

import com.example.demo.domain.diasdasemana.HorarioModulo;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HorarioModuloRepository extends JpaRepository<HorarioModulo, Integer> {
    @Query("SELECT h FROM HorarioModulo h ORDER BY h.nomecompleto")
    HorarioModulo findAllOrderedByNomeCompleto();
}

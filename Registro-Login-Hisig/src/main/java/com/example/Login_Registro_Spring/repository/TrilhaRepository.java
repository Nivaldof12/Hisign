package com.example.Login_Registro_Spring.repository;

import com.example.Login_Registro_Spring.entity.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrilhaRepository  extends JpaRepository<Trilha, Integer> {
    //Modulo select via query
    @Query("SELECT t FROM Trilha t WHERE t.modulo = :modulo")
    List<Trilha> findByModulo(String modulo);
}

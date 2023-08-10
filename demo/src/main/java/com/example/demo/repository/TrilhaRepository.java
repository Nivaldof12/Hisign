package com.example.demo.repository;

import com.example.demo.domain.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrilhaRepository extends JpaRepository<Trilha, Integer> {
    @Query("SELECT t FROM Trilha t WHERE t.modulo = :modulo")
    List<Trilha> findByModulo(String modulo);
}

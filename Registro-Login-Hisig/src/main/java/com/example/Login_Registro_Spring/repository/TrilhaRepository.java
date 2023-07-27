package com.example.Login_Registro_Spring.repository;

import com.example.Login_Registro_Spring.entity.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaRepository  extends JpaRepository<Trilha, Integer> {

}

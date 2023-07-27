package com.example.Login_Registro_Spring.repository;

import com.example.Login_Registro_Spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByTelefone(String telefone);
}

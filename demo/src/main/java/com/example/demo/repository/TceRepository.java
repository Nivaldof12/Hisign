package com.example.demo.repository;

import com.example.demo.domain.Tce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TceRepository extends JpaRepository<Tce, Integer> {
}

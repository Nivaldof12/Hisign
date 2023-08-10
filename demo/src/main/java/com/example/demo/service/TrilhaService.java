package com.example.demo.service;

import com.example.demo.domain.Trilha;
import com.example.demo.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class TrilhaService {
    @Autowired
    private TrilhaRepository trilhaRepository;


    // Método para salvar
    public void incluir(com.example.demo.domain.Trilha trilha) {
        trilhaRepository.save(trilha);
    }

    // Método para excluir com base no ID
    public void excluirTrilhaById(Integer id) {
        trilhaRepository.deleteById(id);
    }

    // Método para listar os Trilhas
    public Collection<Trilha> obterLista(){
        return (Collection<Trilha>) trilhaRepository.findAll();
    }

    public Trilha obterTrilhaporId(Integer id) {
        return trilhaRepository.findById(id).orElse(null);
    }
}
package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Exercicio;
import com.example.demo.repository.ExercicioRepository;

@Service
public class ExercicioService {
    @Autowired
    private ExercicioRepository exercicioRepository;


    // Método para salvar
    public void incluir(Exercicio exercicio) {
        exercicioRepository.save(exercicio);
    }

    // Método para excluir com base no ID
    public void excluirTestePorId(Integer id) {
        exercicioRepository.deleteById(id);
    }

    // Método para listar os Testes
    public Collection<Exercicio> obterLista(){
        return (Collection<Exercicio>) exercicioRepository.findAll();
    }

    public Exercicio obterTestePorId(Integer id) {
        return exercicioRepository.findById(id).orElse(null);
    }
}

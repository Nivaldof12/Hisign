package com.example.demo.service;

import com.example.demo.domain.Tarefa;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    // Método para salvar
    public void incluir(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    // Método para excluir com base no ID
    public void excluirTarefaPorId(Integer id) {
        tarefaRepository.deleteById(id);
    }

    // Método para listar as tarefas
    public Collection<Tarefa> obterLista(){
        return (Collection<Tarefa>) tarefaRepository.findAll();
    }

    //Método para obter tarefa por ID
    public Tarefa obterTarefaPorId(Integer id) {
        return tarefaRepository.findById(id).orElse(null);
    }
}

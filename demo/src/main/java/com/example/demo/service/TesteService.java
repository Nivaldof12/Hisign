package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Teste;
import com.example.demo.repository.TesteRepository;

@Service
public class TesteService {
	@Autowired
    private TesteRepository testeRepository;


    // Método para salvar
    public Teste incluir(Teste teste) {
        return testeRepository.save(teste);
    }

    // Método para excluir com base no ID
    public void excluirTestePorId(Integer id) {
    	testeRepository.deleteById(id);
    }
    
    // Método para listar os Testes
	public Collection<Teste> obterLista(){
		return (Collection<Teste>) testeRepository.findAll();
	}
}

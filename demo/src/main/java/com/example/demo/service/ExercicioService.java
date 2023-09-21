package com.example.demo.service;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Exercicio;
import com.example.demo.repository.ExercicioRepository;

@Service
@Api(tags = "ExercicioService")
public class ExercicioService {
    @Autowired
    private ExercicioRepository exercicioRepository;


    // Método para salvar
    @ApiOperation(value = "Incluir um novo exercicio")
    @ApiResponse(code = 200, message = "Retorna o exercicio incluído", response = Exercicio.class)
    public void incluir(Exercicio exercicio) {
        exercicioRepository.save(exercicio);
    }

    // Método para excluir com base no ID
    @ApiOperation(value = "Excluir um exercicio")
    @ApiResponse(code = 200, message = "Retorna o exercicio excluído", response = Exercicio.class)
    public void excluirTestePorId(Integer id) {
        exercicioRepository.deleteById(id);
    }

    // Método para listar os Testes
    @ApiOperation(value = "Obter a lista de exercicios")
    @ApiResponse(code = 200, message = "Retorna a lista de exercicios", response = Exercicio.class)
    public Collection<Exercicio> obterLista(){
        return (Collection<Exercicio>) exercicioRepository.findAll();
    }

    // Método para obter um Teste por ID
    @ApiOperation(value = "Obter um exercicio por ID")
    @ApiResponse(code = 200, message = "Retorna o exercicio", response = Exercicio.class)
    public Exercicio obterTestePorId(Integer id) {
        return exercicioRepository.findById(id).orElse(null);
    }
}

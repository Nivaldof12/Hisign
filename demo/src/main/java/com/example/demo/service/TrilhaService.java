package com.example.demo.service;

import com.example.demo.domain.Trilha;
import com.example.demo.repository.TrilhaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
@Api(tags = "TrilhaService")
public class TrilhaService {
    @Autowired
    private TrilhaRepository trilhaRepository;


    // Método para salvar

    @ApiOperation(value = "Incluir uma nova trilha")
    @ApiResponse(code = 200, message = "Retorna a trilha incluída", response = Trilha.class)
    public void incluir(com.example.demo.domain.Trilha trilha) {
        trilhaRepository.save(trilha);
    }

    // Método para excluir com base no ID
    @ApiOperation(value = "Excluir uma trilha")
    @ApiResponse(code = 200, message = "Retorna a trilha excluída", response = Trilha.class)
    public void excluirTrilhaById(Integer id) {
        trilhaRepository.deleteById(id);
    }

    // Método para listar os Trilhas
    @ApiOperation(value = "Obter a lista de trilhas")
    @ApiResponse(code = 200, message = "Retorna a lista de trilhas", response = Trilha.class)
    public Collection<Trilha> obterLista(){
        return (Collection<Trilha>) trilhaRepository.findAll();
    }
    @ApiOperation(value = "Obter a lista de trilhas")
    @ApiResponse(code = 200, message = "Retorna a lista de trilhas", response = Trilha.class)
    public Trilha obterTrilhaporId(Integer id) {
        return trilhaRepository.findById(id).orElse(null);
    }
}
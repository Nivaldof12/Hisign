package com.example.demo.service;

import com.example.demo.domain.Tce;
import com.example.demo.repository.TceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Api(tags = "TceService")
public class TceService {
    @Autowired
    private TceRepository tceRepository;
//
    @ApiOperation(value = "Incluir um novo TCE")
    @ApiResponse(code = 200, message = "Retorna o TCE incluído", response = Tce.class)
public Tce incluir(Tce tce) {
        return tceRepository.save(tce);
    }
    @ApiOperation(value = "Encontrar o TCE pelo id")
    @ApiResponse(code = 200, message = "Retorna o TCE", response = Tce.class)
    public Tce obterTcePorId(Integer id) {
        return tceRepository.findById(id).orElse(null);
    }

    @ApiOperation(value = "Obter a lista de TCEs")
    @ApiResponse(code = 200, message = "Retorna a lista de TCEs", response = Tce.class)
    public Collection<Tce> obterLista(){
        return (Collection<Tce>) tceRepository.findAll();
    }
}

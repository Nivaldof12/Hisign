package com.example.demo.service;

import com.example.demo.domain.Tce;
import com.example.demo.domain.Teste;
import com.example.demo.repository.TceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TceService {
    @Autowired
    private TceRepository tceRepository;

public Tce incluir(Tce tce) {
        return tceRepository.save(tce);
    }
    public Tce obterTcePorId(Integer id) {
        return tceRepository.findById(id).orElse(null);
    }

    public Collection<Tce> obterLista(){
        return (Collection<Tce>) tceRepository.findAll();
    }
}

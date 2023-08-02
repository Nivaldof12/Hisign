package com.example.demo.service;

import com.example.demo.domain.HorarioGeral;
import com.example.demo.repository.HorarioGeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioGeralService {
    @Autowired
    private HorarioGeralRepository horarioGeralRepository;

    public HorarioGeral Incluir(HorarioGeral horarioGeral) {
         return horarioGeralRepository.save(horarioGeral);
    }
    public void Excluir(Integer id) {
        horarioGeralRepository.deleteById(id);
    }
    public HorarioGeral ObterPorId(Integer id) {
        return horarioGeralRepository.findById(id).orElse(null);
    }
    public HorarioGeral ObterTodos() {
        return horarioGeralRepository.findAllOrderedByNomeCompleto();
    }
    public HorarioGeral Alterar(HorarioGeral horarioGeral) {
        return horarioGeralRepository.save(horarioGeral);
    }


}

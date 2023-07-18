package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Horario;
import com.example.demo.repository.HorarioRepository;

@Service
public class HorarioService {
	@Autowired
    private HorarioRepository horarioRepository;


    // Método para salvar um horário
    public Horario incluir(Horario horario) {
        return horarioRepository.save(horario);
    }

    // Método para excluir um horário com base no ID
    public void excluirHorarioPorId(Integer id) {
        horarioRepository.deleteById(id);
    }
}

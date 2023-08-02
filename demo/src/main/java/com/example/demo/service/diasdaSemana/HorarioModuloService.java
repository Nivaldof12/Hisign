package com.example.demo.service.diasdaSemana;

import com.example.demo.domain.diasdasemana.HorarioModulo;
import com.example.demo.repository.diasdaSemana.HorarioModuloRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioModuloService {
    public HorarioModuloRepository horarioModuloRepository;

    public void Incluir(HorarioModulo horarioModulo) {
        horarioModuloRepository.save(horarioModulo);
    }
    public void Excluir(Integer id) {
        horarioModuloRepository.deleteById(id);
    }
    public HorarioModulo ObterPorId(Integer id) {
        return horarioModuloRepository.findById(id).orElse(null);
    }
    public HorarioModulo ObterTodos() {
        return horarioModuloRepository.findAllOrderedByNomeCompleto();
    }
    public HorarioModulo Alterar(HorarioModulo horarioModulo) {
        return horarioModuloRepository.save(horarioModulo);
    }

}

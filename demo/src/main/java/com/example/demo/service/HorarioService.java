package com.example.demo.service;

import java.util.Collection;

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
	    // Cálculo de horariototaldiario
	    double entrada = convertStringToHours(horario.getEntrada());
	    double intervalo = convertStringToHours(horario.getIntervalo());
	    double saida = convertStringToHours(horario.getSaida());

	    // Verifica se o intervalo está entre a entrada e a saída
	    if (intervalo >= entrada && intervalo <= saida) {
	        double horariototaldiario = saida - entrada - 1; // Subtrai 1 hora do intervalo
	        horario.setHorariototaldiario(horariototaldiario);
	        
		    // Cálculo de horariototalsemanal
		    double horariototalsemanal = horariototaldiario * 5;
		    horario.setHorariototalsemanal(horariototalsemanal);
		    
	    } else {
	        double horariototaldiario = saida - entrada; // Não considera o intervalo
	        horario.setHorariototaldiario(horariototaldiario);
	        
		    // Cálculo de horariototalsemanal
		    double horariototalsemanal = horariototaldiario * 5;
		    horario.setHorariototalsemanal(horariototalsemanal);
	    }

	    return horarioRepository.save(horario);
	}

	// Método para excluir um horário com base no ID
	public void excluirHorarioPorId(Integer id) {
		horarioRepository.deleteById(id);
	}

	// Método para listar os horários
	public Collection<Horario> obterLista() {
		return (Collection<Horario>) horarioRepository.findAll();
	}

    public Horario obterHorarioPorId(Integer id) {
        return horarioRepository.findById(id).orElse(null);
    }
    
    private double convertStringToHours(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours + minutes / 60.0;
    }
}

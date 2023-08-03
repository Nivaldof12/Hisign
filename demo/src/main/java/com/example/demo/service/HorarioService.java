package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Horario;
import com.example.demo.repository.HorarioRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

	// Método para listar os horários
	public Collection<Horario> obterLista() {
		return (Collection<Horario>) horarioRepository.findAll();
	}

	public Horario obterHorarioPorId(Integer id) {
		return horarioRepository.findById(id).orElse(null);
	}

	//Metodo para calcular as horas trabalhadas
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void SalvarHorasDia() {
		try {
			String sql = "UPDATE horario " +
					"SET horas_trabalhadas_dia = TIME_FORMAT(SUBTIME(TIMEDIFF(saida, entrada), '01:00:00'), '%H:%i:%s'), " +
					"horas_trabalhadas_semana = TIME_FORMAT(TIME_TO_SEC(SUBTIME(TIMEDIFF(saida, entrada), '01:00:00')) / 3600 * 5, '%H:%i:%s')";
			entityManager.createNativeQuery(sql).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


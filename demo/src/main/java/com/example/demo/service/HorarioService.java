package com.example.demo.service;

import java.util.Collection;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Horario;
import com.example.demo.repository.HorarioRepository;

@Service
@Api(tags = "HorarioService")
public class HorarioService {
	@Autowired
	private HorarioRepository horarioRepository;

	// Método para salvar um horário
	@ApiOperation(value = "Incluir horario do candidato")
	@ApiResponse(code = 200, message = "Retorna o horario incluído", response = Horario.class)
    public Horario incluir(Horario horario) {
        horario = calcularHorasTrabalho(horario);
        if (validarHorasTotaisSemanais(horario.getHorariototalsemanal())) {
            return horarioRepository.save(horario);
        } else {
            throw new IllegalArgumentException("A quantidade de horas totais semanais deve estar entre 25 e 30 horas.");
        }
    }

    //Calcula o horário semanal
	@ApiOperation(value = "Calcular horas trabalhadas do candidato")
	@ApiResponse(code = 200, message = "Retorna o horario calculado", response = Horario.class)
	private Horario calcularHorasTrabalho(Horario horario) {
		horario.setHoras_dia_Segunda(calcularHorasDia(horario.getEntrada_Segunda(), horario.getIntervalo_Segunda(),
				horario.getSaida_Segunda()));
		horario.setHoras_dia_Terca(
				calcularHorasDia(horario.getEntrada_Terca(), horario.getIntervalo_Terca(), horario.getSaida_Terca()));
		horario.setHoras_dia_Quarta(calcularHorasDia(horario.getEntrada_Quarta(), horario.getIntervalo_Quarta(),
				horario.getSaida_Quarta()));
		horario.setHoras_dia_Quinta(calcularHorasDia(horario.getEntrada_Quinta(), horario.getIntervalo_Quinta(),
				horario.getSaida_Quinta()));
		horario.setHoras_dia_Sexta(
				calcularHorasDia(horario.getEntrada_Sexta(), horario.getIntervalo_Sexta(), horario.getSaida_Sexta()));
		horario.setHoras_dia_Sabado(calcularHorasDia(horario.getEntrada_Sabado(), horario.getIntervalo_Sabado(),
				horario.getSaida_Sabado()));

		double horasTotalSemana = horario.getHoras_dia_Segunda() + horario.getHoras_dia_Terca()
				+ horario.getHoras_dia_Quarta() + horario.getHoras_dia_Quinta() + horario.getHoras_dia_Sexta()
				+ horario.getHoras_dia_Sabado();

		horario.setHorariototalsemanal(horasTotalSemana);

		return horario;
	}
	
	// Faz a validação para saber Se o valor está fora do intervalo entre 25 e 30
	@ApiOperation(value = "Validar horas totais semanais")
	@ApiResponse(code = 200, message = "Retorna a validação", response = Horario.class)
    private boolean validarHorasTotaisSemanais(double horasTotaisSemanais) {
        return horasTotaisSemanais >= 25 && horasTotaisSemanais <= 30;
    }

    //Calcula o horário do dia
	@ApiOperation(value = "Calcular horas trabalhadas do candidato")
	@ApiResponse(code = 200, message = "Retorna o horario calculado", response = Horario.class)
	private double calcularHorasDia(String entrada, String intervalo, String saida) {
		if (entrada == null || saida == null || entrada.isEmpty() || saida.isEmpty()) {
			return 0; // Retorna 0 se a entrada ou a saída forem nulas ou vazias
		}

		if (intervalo == null || intervalo.isEmpty()) {
			return calcularHorasSemIntervalo(entrada, saida);
		}

		double entradaHora = convertStringToHours(entrada);
		double intervaloHora = convertStringToHours(intervalo);
		double saidaHora = convertStringToHours(saida);

		if (intervaloHora > entradaHora && intervaloHora < saidaHora) {
			return saidaHora - entradaHora - 1;
		} else {
			return calcularHorasSemIntervalo(entrada, saida);
		}
	}
	
	// Método para calcular a entrada e a saída se o intervalo for null
	@ApiOperation(value = "Calcular horas trabalhadas do candidato")
	@ApiResponse(code = 200, message = "Retorna o horario calculado", response = Horario.class)
    private double calcularHorasSemIntervalo(String entrada, String saida) {
        double entradaHora = convertStringToHours(entrada);
        double saidaHora = convertStringToHours(saida);
        return saidaHora - entradaHora;
    }

	// Método para excluir um horário com base no ID
	@ApiOperation(value = "Excluir um horario")
	@ApiResponse(code = 200, message = "Retorna o horario excluído", response = Horario.class)
	public void excluirHorarioPorId(Integer id) {
		horarioRepository.deleteById(id);
	}

	// Método para listar os horários
	@ApiOperation(value = "Obter a lista de horarios")
	@ApiResponse(code = 200, message = "Retorna a lista de horarios", response = Horario.class)
	public Collection<Horario> obterLista() {
		return (Collection<Horario>) horarioRepository.findAll();
	}

	// Método para listar por id
	@ApiOperation(value = "Obter um horario por ID")
	@ApiResponse(code = 200, message = "Retorna o horario", response = Horario.class)
	public Horario obterHorarioPorId(Integer id) {
		return horarioRepository.findById(id).orElse(null);
	}

	// Método que converte String para Hora
	@ApiOperation(value = "Converter String para Hora")
	@ApiResponse(code = 200, message = "Retorna a hora convertida", response = Horario.class)
	private double convertStringToHours(String time) {
		if (time == null || time.isEmpty()) {
			return 0;
		}

		String[] parts = time.split(":");
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);
		return hours + minutes / 60.0;
	}
}

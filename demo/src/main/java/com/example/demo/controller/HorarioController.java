package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;
import java.util.List;

@Controller
@RequestMapping(value = "/horario")
public class HorarioController {

	@Autowired
	private HorarioService horarioService;

	@PostMapping(value = "/add")
	public ResponseEntity<String> incluir(@RequestBody List<Horario> horarios) {
		// Salvar os horários recebidos na requisição
		for (Horario horario : horarios) {
			horarioService.incluir(horario);
		}

		// Calcular as horas trabalhadas diárias e semanais para cada registro
		horarioService.SalvarHorasDia();

		return ResponseEntity.ok("Horários incluídos e horas trabalhadas calculadas!");
	}


	@GetMapping(value = "/lista")
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(horarioService.obterLista());
	}

	@DeleteMapping(value = "/{id}/deletar")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		horarioService.excluirHorarioPorId(id);
		return ResponseEntity.ok("Horário excluído com sucesso!");
	}

	@PutMapping(value = "/{id}/alterar")
	public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Horario horarioAlterado) {
		Horario horarioExistente = horarioService.obterHorarioPorId(id);
		if (horarioExistente != null) {
			// Atualiza os atributos do horário existente com os valores do horário alterado
			horarioExistente.setNomecompleto(horarioAlterado.getNomecompleto());
			horarioExistente.setEntrada(horarioAlterado.getEntrada());
			horarioExistente.setIntervalo(horarioAlterado.getIntervalo());
			horarioExistente.setSaida(horarioAlterado.getSaida());
			horarioExistente.setObservacao(horarioAlterado.getObservacao());
			horarioExistente.setTurno(horarioAlterado.getTurno());
			horarioExistente.setEmpresa(horarioAlterado.getEmpresa());
			horarioExistente.setSetor(horarioAlterado.getSetor());

			// Calcular as horas trabalhadas diárias e semanais antes de salvar as alterações
			horarioService.SalvarHorasDia();

			// Salva as alterações no banco de dados
			horarioService.incluir(horarioExistente);
			return ResponseEntity.ok("Horário alterado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	//Usado Somente para Teste
	@GetMapping("/salvar-horas-dia")
	public ResponseEntity<String> salvarHorasDia() {
		try {
			horarioService.SalvarHorasDia();
			return ResponseEntity.ok("Horas do dia salvas com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar horas do dia: " + e.getMessage());
		}
	}

}

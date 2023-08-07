package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;

@Controller
@RequestMapping(value = "/horario")
public class HorarioController {

	@Autowired
	private HorarioService horarioService;

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Horario horario) {
		horarioService.incluir(horario);
		return ResponseEntity.ok("Horário incluído com sucesso!");
	}

	@GetMapping(value = "/lista")
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(horarioService.obterLista());
	}

	@DeleteMapping(value = "/{id}/excluir")
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

			// Salva as alterações no banco de dados
			horarioService.incluir(horarioExistente);
			return ResponseEntity.ok("Horário alterado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;

@Controller
@RequestMapping(value = "/horario", produces = MediaType.APPLICATION_JSON_VALUE)
public class HorarioController {

	@Autowired
	private HorarioService horarioService;

	@PostMapping(value = "/incluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> incluir(@RequestBody Horario horario) {
		horarioService.incluir(horario);
		return ResponseEntity.ok("Horário incluído com sucesso!");
	}

	@GetMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(horarioService.obterLista());
	}

	@DeleteMapping(value = "/{id}/excluir", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		horarioService.excluirHorarioPorId(id);
		return ResponseEntity.ok("Horário excluído com sucesso!");
	}

	@PutMapping(value = "/{id}/alterar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Horario horarioAlterado) {
		Horario horarioExistente = horarioService.obterHorarioPorId(id);
		if (horarioExistente != null) {
			// Atualiza os atributos do horário existente com os valores do horário alterado
			horarioExistente.setNomecompleto(horarioAlterado.getNomecompleto());
			// Alterar Segunda
			horarioExistente.setEntrada_Segunda(horarioAlterado.getEntrada_Segunda());
			horarioExistente.setIntervalo_Segunda(horarioAlterado.getIntervalo_Segunda());
			horarioExistente.setSaida_Segunda(horarioAlterado.getSaida_Segunda());
			// Alterar Terça
			horarioExistente.setEntrada_Terca(horarioAlterado.getEntrada_Terca());
			horarioExistente.setIntervalo_Terca(horarioAlterado.getIntervalo_Terca());
			horarioExistente.setSaida_Terca(horarioAlterado.getSaida_Terca());
			// Alterar Quarta
			horarioExistente.setEntrada_Quarta(horarioAlterado.getEntrada_Quarta());
			horarioExistente.setIntervalo_Quarta(horarioAlterado.getIntervalo_Quarta());
			horarioExistente.setSaida_Quarta(horarioAlterado.getSaida_Quarta());
			// Alterar Quinta
			horarioExistente.setEntrada_Quinta(horarioAlterado.getEntrada_Quinta());
			horarioExistente.setIntervalo_Quinta(horarioAlterado.getIntervalo_Quinta());
			horarioExistente.setSaida_Quinta(horarioAlterado.getSaida_Quinta());
			// Alterar Sexta
			horarioExistente.setEntrada_Sexta(horarioAlterado.getEntrada_Sexta());
			horarioExistente.setIntervalo_Sexta(horarioAlterado.getIntervalo_Sexta());
			horarioExistente.setSaida_Sexta(horarioAlterado.getSaida_Sexta());
			// Alterar Sabado
			horarioExistente.setEntrada_Sabado(horarioAlterado.getEntrada_Sabado());
			horarioExistente.setIntervalo_Sabado(horarioAlterado.getIntervalo_Sabado());
			horarioExistente.setSaida_Sabado(horarioAlterado.getSaida_Sabado());
			// Alterar
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

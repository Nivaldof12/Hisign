package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;

@Slf4j
@RestController
@RequestMapping(value = "/horario")
public class HorarioController {
///
	@Autowired
	private HorarioService horarioService;

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Validated @RequestBody Horario horario) {
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
	public ResponseEntity<String> alterar(@PathVariable Integer id,@Validated @RequestBody Horario horarioAlterado) {
		Horario horarioExistente = horarioService.obterHorarioPorId(id);
		if (horarioExistente != null) {
			// Registra o horário antigo em log
			log.info("horario com ID:{} foi alterado por: {}  | horário antigo era: \n Entrada Segunda: {}  | Intervalo Segunda: {} | Saída Segunda: {} | Horas na Segunda: {}" +
							"\n Entrada Terça: {} | Intervalo Terça: {} | Saída Terça: {} | Horas na Terça: {}" +
							"\n Entrada Quarta: {} | Intervalo Quarta: {} | Saída Quarta: {} | Horas na Quarta: {}" +
							"\n Entrada Quinta: {} | Intervalo Quinta: {} | Saída Quinta: {} | Horas na Quinta: {}" +
							"\n Entrada Sexta: {} | Intervalo Sexta: {} | Saída Sexta: {} | Horas na Sexta: {}" +
							"\n Entrada Sábado: {} | Intervalo Sábado: {} | Saída Sábado: {} | Horas no Sábado: {}" +
							"\n Observação: {} \n Turno: {} \n Horário Total Semanal: {} \n Empresa: {} \n Setor: {}",
					horarioExistente.getId(), horarioExistente.getNomecompleto(),
					horarioExistente.getEntrada_Segunda(), horarioExistente.getIntervalo_Segunda(), horarioExistente.getSaida_Segunda(), horarioExistente.getHoras_dia_Segunda(),
			horarioExistente.getEntrada_Terca(), horarioExistente.getIntervalo_Terca(), horarioExistente.getSaida_Terca(), horarioExistente.getHoras_dia_Terca(),
					horarioExistente.getEntrada_Quarta(), horarioExistente.getIntervalo_Quarta(), horarioExistente.getSaida_Quarta(), horarioExistente.getHoras_dia_Quarta(),
					horarioExistente.getEntrada_Quinta(), horarioExistente.getIntervalo_Quinta(), horarioExistente.getSaida_Quinta(), horarioExistente.getHoras_dia_Quinta(),
					horarioExistente.getEntrada_Sexta(), horarioExistente.getIntervalo_Sexta(), horarioExistente.getSaida_Sexta(), horarioExistente.getHoras_dia_Sexta(),
					horarioExistente.getEntrada_Sabado(), horarioExistente.getIntervalo_Sabado(), horarioExistente.getSaida_Sabado(), horarioExistente.getHoras_dia_Sabado(),
					horarioExistente.getObservacao(), horarioExistente.getTurno(), horarioExistente.getHorariototalsemanal(), horarioExistente.getEmpresa(), horarioExistente.getSetor());

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

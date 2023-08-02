package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;
import java.util.List;
import com.example.demo.repository.HorarioRepository;

@Controller
@RequestMapping(value = "/horario")
public class HorarioController {
	private final HorarioRepository horarioRepository;

	public HorarioController(HorarioRepository horarioRepository) {
		this.horarioRepository = horarioRepository;
	}


	@Autowired
	private HorarioService horarioService;

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Horario horario) {
		horarioService.incluir(horario);
		return ResponseEntity.ok("Horário incluído com sucesso!");
	}

	@GetMapping(value = "/lista")
	public ResponseEntity<List<Horario>> getHorariosOrdenadosPorNome() {
		List<Horario> horariosOrdenadosPorNome = horarioRepository.findAllOrderedByNomeCompleto();
		return ResponseEntity.ok(horariosOrdenadosPorNome);
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
			horarioService.incluir(horarioExistente);
			return ResponseEntity.ok("Horário alterado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}








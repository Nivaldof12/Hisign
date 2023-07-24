package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;

@Controller
public class HorarioController {

	@Autowired
	private HorarioService horarioService;

	@GetMapping(value = "/horario")
	public String telaCadastro() {
		return "cadastro";
	}

	@PostMapping(value = "/horario/incluir")
	public String incluir(Horario horario) {

		horarioService.incluir(horario);

		return "redirect:/";
	}

	@GetMapping(value = "/horario/lista")
	public String telaLista(Model model) {

		model.addAttribute("horarios", horarioService.obterLista());

		return "listahorario";
	}

	@GetMapping(value = "/horario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		horarioService.excluirHorarioPorId(id);

		return "redirect:/horario/lista";
	}

	@GetMapping(value = "/horario/{id}/editar")
	public String telaEditar(@PathVariable Integer id, Model model) {
		Horario horario = horarioService.obterHorarioPorId(id);
		
			model.addAttribute("horarioss", horario);
			
			return "edicaohorario";

	}

	@PostMapping(value = "/horario/{id}/alterar")
	public String alterar(@PathVariable Integer id, Horario horarioAlterado) {
		Horario horarioExistente = horarioService.obterHorarioPorId(id);
		if (horarioExistente != null) {
			// Atualiza os atributos do horário existente com os valores do horário alterado
			horarioExistente.setEntrada(horarioAlterado.getEntrada());
			horarioExistente.setIntervalo(horarioAlterado.getIntervalo());
			horarioExistente.setSaida(horarioAlterado.getSaida());
			horarioExistente.setObservacao(horarioAlterado.getObservacao());
			horarioExistente.setTurno(horarioAlterado.getTurno());

			// Salva as alterações no banco de dados
			horarioService.incluir(horarioExistente);
		} else {
			// O horário com o ID especificado não foi encontrado, faça algo aqui (por
			// exemplo, exibir uma mensagem de erro)
		}
		return "redirect:/horario/lista";
	}

}

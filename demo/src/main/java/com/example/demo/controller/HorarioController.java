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
	
}

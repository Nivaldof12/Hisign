package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Horario;
import com.example.demo.service.HorarioService;

@Controller
public class HorarioController {
	
	@GetMapping(value = "/")
	public String telaIndex() {
		return "index";
	}

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
}

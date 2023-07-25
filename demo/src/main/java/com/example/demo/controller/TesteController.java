package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Teste;
import com.example.demo.service.TesteService;


@Controller
public class TesteController {


	@Autowired
	private TesteService testeService;
	
	@GetMapping(value = "/teste")
	public String telaCadastro() {
		return "teste/cadastro";
	}
	
	@PostMapping(value = "/teste/incluir")
	public String incluir(Teste teste) {

		testeService.incluir(teste);		
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/teste/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("testes", testeService.obterLista());
		
		return "teste/lista";
	}
	
	@GetMapping(value = "/teste/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		testeService.excluirTestePorId(id);

		return "redirect:/teste/lista";
	}
	
	@GetMapping(value = "/teste/{id}/editar")
	public String telaEditar(@PathVariable Integer id, Model model) {
		Teste teste = testeService.obterTestePorId(id);
		
			model.addAttribute("testess", teste);
			
			return "teste/edicaoteste";

	}

	@PostMapping(value = "/teste/{id}/alterar")
	public String alterar(@PathVariable Integer id, Teste testeAlterado) {
		Teste testeExistente = testeService.obterTestePorId(id);
		if (testeExistente != null) {
			// Atualiza os atributos do horário existente com os valores do horário alterado
			testeExistente.setNometeste(testeAlterado.getNometeste());
			testeExistente.setResumo(testeAlterado.getResumo());
			testeExistente.setFileData(testeAlterado.getFileData());
			testeExistente.setLinkgit(testeAlterado.getLinkgit());
			testeExistente.setEquipe(testeAlterado.getEquipe());

			// Salva as alterações no banco de dados
			testeService.incluir(testeExistente);
		} else {
			// O horário com o ID especificado não foi encontrado, faça algo aqui (por
			// exemplo, exibir uma mensagem de erro)
		}
		return "redirect:/teste/lista";
	}
	
}

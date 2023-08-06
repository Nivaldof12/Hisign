package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Teste;
import com.example.demo.service.TesteService;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/teste")
@CrossOrigin
public class TesteController {

	private final TesteService testeService;

	public TesteController(TesteService testeService) {
		this.testeService = testeService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Teste> incluir(@RequestBody Teste teste) {
		Teste novoTeste = testeService.incluir(teste);
		return new ResponseEntity<>(novoTeste, HttpStatus.CREATED);
	}


	@GetMapping(value = "/lista")
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(testeService.obterLista());
	}

	@DeleteMapping(value = "/{id}/deletar")
	public ResponseEntity<Map<String, String>> excluir(@PathVariable Integer id) {
		testeService.excluirTestePorId(id);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Teste excluído com sucesso!");
		return ResponseEntity.ok(response);
	}

	@PutMapping(value = "/{id}/alterar")
	public ResponseEntity<Map<String, String>> alterar(@PathVariable Integer id, @RequestBody Teste testeAlterado) {
		Teste testeExistente = testeService.obterTestePorId(id);
		if (testeExistente != null) {
			testeExistente.setNometeste(testeAlterado.getNometeste());
			testeExistente.setResumo(testeAlterado.getResumo());
			testeExistente.setLinkgit(testeAlterado.getLinkgit());
			testeExistente.setEquipe(testeAlterado.getEquipe());

			testeService.incluir(testeExistente);

			Map<String, String> response = new HashMap<>();
			response.put("message", "Teste alterado com sucesso!");
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping(value = "/uploadpdf")
	public String uploadFile(@RequestParam("file") MultipartFile[] file) {
		for (MultipartFile files : file) {
			testeService.saveFile(files);
		}
		return "redirect:/";
	}
	@GetMapping(value = "/downloadpdf/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
		Teste teste = testeService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(teste.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + teste.getDocName() + "\"")
				.body(new ByteArrayResource(teste.getData()));
	}
}


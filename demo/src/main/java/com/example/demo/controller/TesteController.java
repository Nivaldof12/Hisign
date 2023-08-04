package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Teste;
import com.example.demo.service.TesteService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/teste")
public class TesteController {

	private final TesteService testeService;

	public TesteController(TesteService testeService) {
		this.testeService = testeService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Map<String, String>> incluir(@RequestBody Teste teste) {
		testeService.incluir(teste);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Teste incluído com sucesso!");
		return ResponseEntity.ok(response);
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

	@PostMapping("/{id}/uploadpdf")
	public ResponseEntity<Map<String, String>> uploadFile(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
		Teste teste = testeService.obterTestePorId(id);
		if (teste != null) {
			try {
				teste.setFile_data(file.getBytes());

				testeService.atualizar(teste);

				Map<String, String> response = new HashMap<>();
				response.put("message", "Arquivo enviado com sucesso!");
				return ResponseEntity.ok(response);
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@GetMapping("/{id}/downloadpdf")
	public ResponseEntity<byte[]> downloadPDF(@PathVariable Integer id) {
		Teste teste = testeService.obterTestePorId(id);
		if (teste != null && teste.getFile_data() != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("attachment", "arquivo.pdf");
			return new ResponseEntity<>(teste.getFile_data(), headers, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

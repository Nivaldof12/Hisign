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

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/teste")
public class TesteController {

	@Autowired
	private TesteService testeService;
	
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Teste teste) {
		testeService.incluir(teste);		
		return ResponseEntity.ok("Teste incluído com sucesso!");
	}
	
	@GetMapping(value = "/lista")
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(testeService.obterLista());
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		testeService.excluirTestePorId(id);
		return ResponseEntity.ok("Teste excluído com sucesso!");
	}

	@PutMapping(value = "/{id}/alterar")
	public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Teste testeAlterado) {
		Teste testeExistente = testeService.obterTestePorId(id);
		if (testeExistente != null) {
			// Atualiza os atributos do teste existente com os valores do teste alterado
			testeExistente.setNometeste(testeAlterado.getNometeste());
			testeExistente.setResumo(testeAlterado.getResumo());
			testeExistente.setArquivo(testeAlterado.getArquivo());
			testeExistente.setLinkgit(testeAlterado.getLinkgit());
			testeExistente.setEquipe(testeAlterado.getEquipe());

			// Salva as alterações no banco de dados
			testeService.incluir(testeExistente);
			return ResponseEntity.ok("Teste alterado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/{id}/uploadpdf")
	public ResponseEntity<Map<String, String>> uploadFile(@PathVariable String id, @RequestParam("file") MultipartFile file) {
		try {
			Teste teste = testeService.obterTestePorId(Integer.parseInt(id));

			if (teste != null) {
				teste.setArquivo(file.getBytes());
				testeService.incluir(teste);

				Map<String, String> response = new HashMap<>();
				response.put("message", "Arquivo enviado com sucesso!");

				return ResponseEntity.ok(response);
			} else {
				Map<String, String> response = new HashMap<>();
				response.put("message", "Registro de teste não encontrado com o ID fornecido.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // Retornar resposta 404 com corpo
			}
		} catch (NumberFormatException e) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "ID inválido fornecido.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response); // Retornar resposta 400 com corpo
		} catch (Exception e) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Erro ao enviar o arquivo");
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response); // Retornar resposta de erro genérico com corpo
		}
	}
	@GetMapping("/{id}/downloadpdf")
	public ResponseEntity<byte[]> downloadFile(@PathVariable Integer id) {
		Teste teste = testeService.obterTestePorId(id);

		if (teste != null && teste.getArquivo() != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "arquivo.pdf");
			headers.setContentType(MediaType.APPLICATION_PDF);

			return ResponseEntity.ok()
					.headers(headers)
					.body(teste.getArquivo());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

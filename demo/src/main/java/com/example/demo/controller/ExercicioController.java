package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.Exercicio;
import com.example.demo.service.ExercicioService;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/teste")
@Api(value = "API REST de Exercícios para a entrada dos candiadatos")
public class ExercicioController {
////
	@Autowired
	private ExercicioService exercicioService;


	@PostMapping(value = "/incluir")
	@ApiOperation(value = "Incluir um novo exercício")
	public ResponseEntity<String> incluir(@RequestBody Exercicio exercicio) {
		exercicioService.incluir(exercicio);
		return ResponseEntity.ok("Teste incluído com sucesso!");
	}
	
	@GetMapping(value = "/lista")
	@ApiOperation(value = "Obter a lista de exercícios")
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(exercicioService.obterLista());
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	@ApiOperation(value = "Excluir um exercício")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		exercicioService.excluirTestePorId(id);
		return ResponseEntity.ok("Teste excluído com sucesso!");
	}

	@PutMapping(value = "/{id}/alterar")
	@ApiOperation(value = "Alterar um exercício")
	public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Exercicio exercicioAlterado) {
		Exercicio exercicioExistente = exercicioService.obterTestePorId(id);
		if (exercicioExistente != null) {
			// Atualiza os atributos do teste existente com os valores do teste alterado
			exercicioExistente.setNometeste(exercicioAlterado.getNometeste());
			exercicioExistente.setResumo(exercicioAlterado.getResumo());
			exercicioExistente.setArquivo(exercicioAlterado.getArquivo());
			exercicioExistente.setLinkgit(exercicioAlterado.getLinkgit());
			exercicioExistente.setEquipe(exercicioAlterado.getEquipe());

			// Salva as alterações no banco de dados
			exercicioService.incluir(exercicioExistente);
			return ResponseEntity.ok("Teste alterado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/{id}/uploadpdf")
	@ApiOperation(value = "Upload de arquivo PDF")
	public ResponseEntity<Map<String, String>> uploadFile(@PathVariable String id, @RequestParam("file") MultipartFile file) {
		try {
			Exercicio exercicio = exercicioService.obterTestePorId(Integer.parseInt(id));

			if (exercicio != null) {
				exercicio.setArquivo(file.getBytes());
				exercicioService.incluir(exercicio);

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
	@ApiOperation(value = "Download de arquivo PDF")
	public ResponseEntity<byte[]> downloadFile(@PathVariable Integer id) {
		Exercicio exercicio = exercicioService.obterTestePorId(id);

		if (exercicio != null && exercicio.getArquivo() != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "arquivo.pdf");
			headers.setContentType(MediaType.APPLICATION_PDF);

			return ResponseEntity.ok()
					.headers(headers)
					.body(exercicio.getArquivo());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

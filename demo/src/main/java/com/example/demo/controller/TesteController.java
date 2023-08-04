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

@Controller
@RequestMapping(value = "/teste")
public class TesteController {

	@Autowired
	private TesteService testeService;
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> incluir(@RequestBody Teste teste) {
		testeService.incluir(teste);		
		return ResponseEntity.ok("Teste incluído com sucesso!");
	}
	
	@GetMapping(value = "/lista")
	public ResponseEntity<Object> telaLista() {
		return ResponseEntity.ok(testeService.obterLista());
	}
	
	@DeleteMapping(value = "/{id}/deletar")
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
			testeExistente.setFile_data(testeAlterado.getFile_data());
			testeExistente.setLinkgit(testeAlterado.getLinkgit());
			testeExistente.setEquipe(testeAlterado.getEquipe());

			// Salva as alterações no banco de dados
			testeService.incluir(testeExistente);
			return ResponseEntity.ok("Teste alterado com sucesso!");
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

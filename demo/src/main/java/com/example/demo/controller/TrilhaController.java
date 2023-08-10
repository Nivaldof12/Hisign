package com.example.demo.controller;

import com.example.demo.domain.Trilha;
import com.example.demo.repository.TrilhaRepository;
import com.example.demo.service.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trilha")
public class TrilhaController {

    private final TrilhaRepository trilhaRepository;

    @Autowired
    private TrilhaService trilhaService;

    @Autowired
    public TrilhaController(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<String> incluir(@RequestBody Trilha trilha) {
        trilhaService.incluir(trilha);
        return ResponseEntity.ok("Trilha incluída com sucesso!");
    }



    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        trilhaService.excluirTrilhaById(id);
        return ResponseEntity.ok("Trilha excluída com sucesso!");
    }
    @GetMapping("/lista")
    public ResponseEntity<List<Trilha>> getTrilhasByModulo(@RequestParam("modulo") String modulo) {
        List<Trilha> trilhas = trilhaRepository.findByModulo(modulo);
        if (!trilhas.isEmpty()) {
            return new ResponseEntity<>(trilhas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Trilha trilhaAlterado) {
        Trilha trilhaexistente = trilhaService.obterTrilhaporId(id);
        if (trilhaexistente != null) {
            // Atualiza os atributos do trilha existente com os valores do trilha alterado
            trilhaexistente.setNome_aula(trilhaexistente.getNome_aula());
            trilhaexistente.setDescricao(trilhaexistente.getDescricao());
            trilhaexistente.setResumo_Envio(trilhaexistente.getResumo_Envio());
            return ResponseEntity.ok("Trilha alterado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//
    @PostMapping("/{id}/uploadtrilha")
    public ResponseEntity<Map<String, String>> uploadFile(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        try {
            Trilha trilha = trilhaService.obterTrilhaporId(Integer.parseInt(id));

            if (trilha != null) {
                trilha.setResumo_Envio(file.getBytes());
                trilhaService.incluir(trilha);

                Map<String, String> response = new HashMap<>();
                response.put("message", "Arquivo enviado com sucesso!");

                return ResponseEntity.ok(response);
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("message", "Registro de trilha não encontrado com o ID fornecido.");
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
    @GetMapping("/{id}/downloadtrilha")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Integer id) {
        Trilha trilha = trilhaService.obterTrilhaporId(id);

        if (trilha != null && trilha.getResumo_Envio() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "arquivo.pdf");
            headers.setContentType(MediaType.APPLICATION_PDF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(trilha.getResumo_Envio());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
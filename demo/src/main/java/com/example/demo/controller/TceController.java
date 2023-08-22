package com.example.demo.controller;

import com.example.demo.domain.Tce;
import com.example.demo.service.TceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tce")
public class TceController {
    @Autowired
    private TceService tceService;


    @PostMapping(value = "/{id}/uploadtce")
    public ResponseEntity<Map<String, String>> uploadFile(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        try {
            Tce tce = tceService.obterTcePorId(Integer.parseInt(id));

            if (tce != null) {
                tce.setArquivo(file.getBytes());
                tceService.incluir(tce);

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
    @GetMapping("/{id}/downloadtce")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Integer id) {
        Tce tce = tceService.obterTcePorId(id);

        if (tce != null && tce.getArquivo() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "arquivo.pdf");
            headers.setContentType(MediaType.APPLICATION_PDF);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(tce.getArquivo());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
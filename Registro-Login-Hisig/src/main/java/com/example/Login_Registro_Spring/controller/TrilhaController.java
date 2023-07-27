package com.example.Login_Registro_Spring.controller;

import com.example.Login_Registro_Spring.entity.Trilha;
import com.example.Login_Registro_Spring.service.TrilhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/trilha")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TrilhaController {

    @Autowired
    private TrilhaService trilhaService;

    @GetMapping
    public ResponseEntity<Collection<Trilha>> getAllTrilhas() {
        Collection<Trilha> trilhas = trilhaService.getAll();
        return ResponseEntity.ok(trilhas);
    }

    @PostMapping("/add")
    public ResponseEntity<Trilha> incluir(@RequestBody Trilha trilha) {
        Trilha savedTrilha = trilhaService.Add(trilha);
        return ResponseEntity.ok(savedTrilha);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> getTrilhaById(@PathVariable Integer id) {
        Trilha trilha = trilhaService.getTrilhaById(id);
        if (trilha != null) {
            return ResponseEntity.ok(trilha);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        trilhaService.deleteTrilhaById(id);
        return ResponseEntity.ok("Trilha com o ID " + id + " foi deletada.");
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadFile(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        try {
            trilhaService.saveFile(id, file);
            return ResponseEntity.ok("Arquivo enviado com sucesso " + id);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro de upload de arquivo.");
        }
    }
}

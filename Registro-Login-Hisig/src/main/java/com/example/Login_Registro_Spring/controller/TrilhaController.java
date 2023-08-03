package com.example.Login_Registro_Spring.controller;

import com.example.Login_Registro_Spring.entity.Trilha;
import com.example.Login_Registro_Spring.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilha")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TrilhaController {

    private final TrilhaRepository trilhaRepository;

    @Autowired
    public TrilhaController(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }


    @GetMapping
    public ResponseEntity<List<Trilha>> getAllTrilhas() {
        List<Trilha> trilhas = trilhaRepository.findAll();
        return new ResponseEntity<>(trilhas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> getTrilhaById(@PathVariable Integer id) {
        Trilha trilha = trilhaRepository.findById(id).orElse(null);
        if (trilha != null) {
            return new ResponseEntity<>(trilha, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
    @PostMapping("/add")
    public ResponseEntity<Trilha> createTrilha(@RequestBody Trilha trilha) {
        Trilha newTrilha = trilhaRepository.save(trilha);
        return new ResponseEntity<>(newTrilha, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/alterar")
    public ResponseEntity<Trilha> updateTrilha(@PathVariable Integer id, @RequestBody Trilha trilha) {
        Trilha existingTrilha = trilhaRepository.findById(id).orElse(null);
        if (existingTrilha != null) {
            trilha.setId(existingTrilha.getId());
            Trilha updatedTrilha = trilhaRepository.save(trilha);
            return new ResponseEntity<>(updatedTrilha, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/Deletar")
    public ResponseEntity<Void> deleteTrilha(@PathVariable Integer id) {
        Trilha trilha = trilhaRepository.findById(id).orElse(null);
        if (trilha != null) {
            trilhaRepository.delete(trilha);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
}

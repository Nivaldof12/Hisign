package com.example.demo.controller;

import com.example.demo.domain.HorarioGeral;
import com.example.demo.repository.HorarioGeralRepository;
import com.example.demo.service.HorarioGeralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/horariogeral")
public class HorarioGeralController {
    private final HorarioGeralRepository horarioGeralRepository;

    public HorarioGeralController(HorarioGeralRepository horarioGeralRepository) {
        this.horarioGeralRepository = horarioGeralRepository;
    }

    @Autowired
    private  HorarioGeralService horarioGeralService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> incluir(@RequestBody HorarioGeral horarioGeral) {
        horarioGeralService.Incluir(horarioGeral);
        return ResponseEntity.ok("Horário Geral incluído com sucesso!");
    }
    @GetMapping(value = "/lista")
    public ResponseEntity<HorarioGeral> getHorarioGeral() {
        HorarioGeral horarioGeral = horarioGeralService.ObterTodos();
        return ResponseEntity.ok(horarioGeral);
    }
    @DeleteMapping(value = "/{id}/deletar")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        horarioGeralService.Excluir(id);
        return ResponseEntity.ok("Horário Geral excluído com sucesso!");
    }
    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody HorarioGeral horarioGeralAlterado) {
        HorarioGeral horarioGeralExistente = horarioGeralService.ObterPorId(id);
        if (horarioGeralExistente != null) {
            horarioGeralService.Alterar(horarioGeralExistente);
            return ResponseEntity.ok("Horário Geral alterado com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

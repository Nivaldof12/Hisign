package com.example.demo.controller;

import com.example.demo.domain.Tarefa;
import com.example.demo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping(value = "/incluir")
    public ResponseEntity<String> incluir(@Validated @RequestBody Tarefa tarefa) {
        tarefaService.incluir(tarefa);
        return ResponseEntity.ok("Tarefa incluída com sucesso!");
    }

    @GetMapping(value = "/lista")
    public ResponseEntity<Object> telaLista() {
        return ResponseEntity.ok(tarefaService.obterLista());
    }
}

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

    @DeleteMapping(value = "/{id}/excluir")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        tarefaService.excluirTarefaPorId(id);
        return ResponseEntity.ok("Tarefa excluída com sucesso!");
    }

    @PutMapping(value = "/{id}/alterar")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @Validated @RequestBody Tarefa tarefaAlterada) {
        Tarefa tarefaexistente = tarefaService.obterTarefaPorId(id);
        if (tarefaexistente != null) {
            // Atualiza os atributos da tarefa existente com os valores da tarefa alterada
            tarefaexistente.setData(tarefaAlterada.getData());
            tarefaexistente.setTitulo(tarefaAlterada.getTitulo());
            tarefaexistente.setAnotacao(tarefaAlterada.getAnotacao());
            tarefaexistente.setHorario_inicio(tarefaAlterada.getHorario_inicio());
            tarefaexistente.setHorario_fim(tarefaAlterada.getHorario_fim());
            tarefaexistente.setLink_reuniao(tarefaAlterada.getLink_reuniao());

            // Salva as alterações no banco de dados
            tarefaService.incluir(tarefaexistente);
            return ResponseEntity.ok("Tarefa alterada com sucesso!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

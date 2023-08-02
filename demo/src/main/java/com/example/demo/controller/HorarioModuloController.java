package com.example.demo.controller;

import com.example.demo.domain.diasdasemana.HorarioModulo;
import com.example.demo.repository.diasdaSemana.HorarioModuloRepository;
import com.example.demo.service.diasdaSemana.HorarioModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/horariomodulo")
public class HorarioModuloController {
    private final HorarioModuloRepository horarioModuloRepository;

    public HorarioModuloController(HorarioModuloRepository horarioModuloRepository) {
        this.horarioModuloRepository = horarioModuloRepository;
    }

    @Autowired
    private HorarioModuloService horarioModuloService;
    @PostMapping(value = "/incluir")
    public void Incluir(HorarioModulo horarioModulo) {
        horarioModuloService.Incluir(horarioModulo);
    }
    @DeleteMapping
    public void Excluir(Integer id) {
        horarioModuloService.Excluir(id);
    }
    @PostMapping(value = "/{id}/obter")
    public HorarioModulo ObterPorId(Integer id) {
        return horarioModuloService.ObterPorId(id);
    }
    @GetMapping(value = "/lista")
    public HorarioModulo ObterTodos() {
        return horarioModuloService.ObterTodos();
    }
    @PostMapping(value = "/alterar")
    public HorarioModulo Alterar(HorarioModulo horarioModulo) {
        return horarioModuloService.Alterar(horarioModulo);
    }

}

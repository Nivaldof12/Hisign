package com.example.demo.controller;

import com.example.demo.domain.usuario.AutenticacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data)
}

package com.example.demo.controller;

import com.example.demo.domain.usuario.AutenticacaoDTO;
import com.example.demo.domain.usuario.RegistroDTO;
import com.example.demo.domain.usuario.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity register(@RequestBody @Valid RegistroDTO data){
        //verifica se já tem o mesmo email cadastrado
        if(this.usuarioRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        //encryptar a senha do usuário
        String encryptSenha = new BCryptPasswordEncoder().encode(data.senha());

        Usuario usuario = new Usuario(data.email(), encryptSenha, data.nome(), data.regra());
        this.usuarioRepository.save(usuario);
        return  ResponseEntity.ok().build();
    }
}

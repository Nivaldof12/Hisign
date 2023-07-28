package com.example.Login_Registro_Spring.controller;

import com.example.Login_Registro_Spring.dto.UserDto;
import com.example.Login_Registro_Spring.entity.User;
import com.example.Login_Registro_Spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Pagina Principal");
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginForm() {
        return ResponseEntity.ok(" por favor se logue");
    }

    @GetMapping("register")
    public ResponseEntity<String> showRegistrationForm() {
        return ResponseEntity.ok("por favor se registre");
    }

    @PostMapping("/register/save")
    public ResponseEntity<String> registro(@Valid @RequestBody UserDto user) {
        User existing = userService.findByTelefone(user.getTelefone());
        if (existing != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("uma conta com esse telefone já existe");
        }
        userService.saveUser(user);
        return ResponseEntity.ok("está tudo certo, você foi registrado");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> usuariosRegistrados() {
        List<UserDto> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
}

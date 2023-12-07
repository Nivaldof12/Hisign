package com.example.demo.domain.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record RegistroDTO(
        @Email(message = "Email inválido!")
        @NotBlank(message = "Email não pode ficar em branco!")
        String email,
        @NotBlank(message = "Senha não pode ficar em branco!")
        @Size(min = 5, max = 500, message = "Senha inválida!(Deve conter no mínimo 5 caracteres)")
        String senha,
        @NotBlank(message = "Nome não pode ficar em branco!")
        @Size(min = 3, max = 50, message = "Nome inválido!(Deve conter no mínimo 3 caracteres e no máximo 50)")
        String nome,
        String regra) {
}

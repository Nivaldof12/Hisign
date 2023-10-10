package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tceadicionar")
@Getter
@Setter
public class Tce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob 
    @Column(name = "Arquivo")
    private byte[] arquivo;

    @Column(name = "nomecompleto")
    @NotBlank(message = "Nome não pode ficar em branco!")
    @Size(min = 0, max = 50, message = "Entrada do nome inválido!(Deve conter no máximo 50 caracteres)")
    @Pattern(regexp = "^[a-zA-ZÀ-ÿ ]+$", message = "O campo de nome deve conter apenas letras, acentos e espaços.")
    private String nomecompleto;
}

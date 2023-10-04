package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trilha")
@Getter
@Setter
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_aula")
    @NotBlank(message = "Nome da aula não pode ficar em branco!")
    @Size(min = 1, max = 50, message = "Entrada do nome da aula inválida!(Deve conter no máximo 50 caracteres)")
    private String nome_aula;

    @Column(name = "descricao")
    @Size(min = 0, max = 700, message = "Entrada da descrição inválida!(Deve conter no máximo 700 caracteres)")
    private String descricao;

    @Column(name = "link_aula")
    @NotBlank(message = "O link da aula não pode ficar em branco!")
    @Size(min = 0, max = 200, message = "Entrada do link da aula inválida!(Deve conter no máximo 200 caracteres)")
    private String link_aula;

    @Column(name = "Resumo_Envio")
    private byte[] Resumo_Envio;

    @Column(name = "modulo")
    @NotBlank(message = "O módulo não pode ficar em branco!")
    @Size(min = 0, max = 50, message = "Entrada do módulo inválida!(Deve conter no máximo 50 caracteres)")
    private String modulo;


}
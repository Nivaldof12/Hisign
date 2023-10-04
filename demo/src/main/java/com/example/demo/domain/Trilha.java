package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    private String nome_aula;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "link_aula")
    @NotBlank(message = "O link da aula não pode ficar em branco!")
    private String link_aula;

    @Column(name = "Resumo_Envio")
    private byte[] Resumo_Envio;

    @Column(name = "modulo")
    @NotBlank(message = "O módulo não pode ficar em branco!")
    private String modulo;


}
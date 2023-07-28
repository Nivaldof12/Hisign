package com.example.Login_Registro_Spring.entity;

import jakarta.persistence.*;
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
    private String nome_aula;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "link_aula")
    private String link_aula;

    @Column(name = "Resumo_Envio")
    private byte[] Resumo_Envio;


    @Column(name = "Modulo")
    private String modulo;
}

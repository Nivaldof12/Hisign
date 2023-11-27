package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data")
    @Size(min = 0, max = 20, message = "Data inválida!")
    private String data;

    @Column(name = "titulo")
    @Size(min = 0, max = 100, message = "Entrada do link inválido!(Deve conter no máximo 100 caracteres)")
    private String titulo;

    @Column(name = "horario_inicio")
    @Size(min = 0, max = 20, message = "Entrada do início inválida!")
    private String horario_inicio;

    @Column(name = "horario_fim")
    @Size(min = 0, max = 20, message = "Entrada do fim inválida!")
    private String horario_fim;

    @Column(name = "link_reuniao")
    @Size(min = 0, max = 100, message = "Entrada do link da reunião inválido!(Deve conter no máximo 100 caracteres)")
    private String link_reuniao;

    @Column(name = "anotacao")
    @Size(min = 0, max = 700, message = "Entrada de anotações inválido!(Deve conter no máximo 700 caracteres)")
    private String anotacao;
}

package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data")
    @NotBlank(message = "Data não pode ficar em branco!")
    @Size(min = 0, max = 20, message = "Data inválida!")
    private String data;

    @Column(name = "titulo")
    @NotBlank (message = "Título não pode ficar em branco!")
    @Size(min = 0, max = 100, message = "Entrada do título inválida!(Deve conter no máximo 100 caracteres)")
    private String titulo;

    @Column(name = "horario_inicio")
    @NotBlank (message = "Horário de inicio não pode ficar em branco!")
    @Size(min = 0, max = 20, message = "Entrada do início inválida!")
    private String horario_inicio;

    @Column(name = "horario_fim")
    @NotBlank (message = "Horário do fim não pode ficar em branco!")
    @Size(min = 0, max = 20, message = "Entrada do fim inválida!")
    private String horario_fim;

    @Column(name = "link_reuniao")
    @Size(min = 0, max = 100, message = "Entrada do link da reunião inválido!(Deve conter no máximo 100 caracteres)")
    private String link_reuniao;

    @Column(name = "anotacao")
    @Size(min = 0, max = 700, message = "Entrada de anotações inválido!(Deve conter no máximo 700 caracteres)")
    private String anotacao;
}

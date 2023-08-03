package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomecompleto")
    private String nomecompleto;
    
    @Column(name = "entrada")
    private String entrada;

    @Column(name = "intervalo")
    private String intervalo;

    @Column(name = "saida")
    private String saida;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "turno")
    private String turno;

    @Column(name = "horas_trabalhadas_dia")
    private Time horariototaldiario;

    @Column(name = "horas_trabalhadas_semana")
    private Time horariototalsemanal;
    
    @Column(name = "empresa")
    private String empresa;
    
    @Column(name = "setor")
    private String setor;


}
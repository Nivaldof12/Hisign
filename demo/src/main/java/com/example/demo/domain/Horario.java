package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
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
    private Double horariototaldiario;

    @Column(name = "horas_trabalhadas_semana")
    private Double horariototalsemanal;
    
    @Column(name = "empresa")
    private String empresa;
    
    @Column(name = "setor")
    private String setor;


	}
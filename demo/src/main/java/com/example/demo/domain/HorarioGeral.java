package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "horariogeral")
public class HorarioGeral {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomecompleto")
    private String nomecompleto;

    @Column(name = "entrada_Segunda")
    private String entrada_Segunda;

    @Column(name = "intervalo_Segunda")
    private String intervalo_Segunda;

    @Column(name = "saida_Segunda")
    private String saida_Segunda;

    @Column(name = "entrada_Terca")
    private String entrada_Terca;

    @Column(name = "intervalo_Terca")
    private String intervalo_Terca;

    @Column(name = "saida_Terca")
    private String saida_Terca;

    @Column(name = "entrada_Quarta")
    private String entrada_Quarta;

    @Column(name = "intervalo_Quarta")
    private String intervalo_Quarta;

    @Column(name = "saida_Quarta")
    private String saida_Quarta;

    @Column(name = "entrada_Quinta")
    private String entrada_Quinta;

    @Column(name = "intervalo_Quinta")
    private String intervalo_Quinta;

    @Column(name = "saida_Quinta")
    private String saida_Quinta;

    @Column(name = "entrada_Sexta")
    private String entrada_Sexta;

    @Column(name = "intervalo_Sexta")
    private String intervalo_Sexta;

    @Column(name = "saida_Sexta")
    private String saida_Sexta;

    @Column(name = "entrada_Sabado")
    private String entrada_Sabado;

    @Column(name = "intervalo_Sabado")
    private String intervalo_Sabado;

    @Column(name = "saida_Sabado")
    private String saida_Sabado;

}

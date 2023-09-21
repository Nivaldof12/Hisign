package com.example.demo.domain;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trilha")
@Getter
@Setter
@ApiModel(description = "Campos referentes a trilha Inicial. ")
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador único da trilha")
    private Integer id;

    @Column(name = "nome_aula")
    @ApiModelProperty(notes = "Nome da aula")
    private String nome_aula;

    @Column(name = "descricao")
    @ApiModelProperty(notes = "Descrição da aula")
    private String descricao;

    @Column(name = "link_aula")
    @ApiModelProperty(notes = "Link da aula")
    private String link_aula;

    @Column(name = "Resumo_Envio")
    @ApiModelProperty(notes = "Envio/recebimento do resumo da aula")
    private byte[] Resumo_Envio;


    @Column(name = "modulo")
    @ApiModelProperty(notes = "Modulo da aula exemplo: frontend, backend, UI/UX")
    private String modulo;


}
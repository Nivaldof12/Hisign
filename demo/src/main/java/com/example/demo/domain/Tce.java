package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tce")
@Getter
@Setter
@ApiModel(description = "Campos referentes ao TCE. ")
public class Tce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador único do TCE")
    private Integer id;

    @Column(name = "Arquivo")
    @ApiModelProperty(notes = "Arquivo do TCE")
    private byte[] arquivo;

    @Column(name = "nomecompleto")
    @ApiModelProperty(notes = "Nome completo do candidato // Temporario Ate a chegada do usuario")
    private String nomecompleto;
}

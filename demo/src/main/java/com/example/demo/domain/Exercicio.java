package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Exercicio")
@Getter
@Setter
@ApiModel(description = "Campos referentes a exercicios. ")
public class Exercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identificador único do exercício")
	private Integer id;

	@Column(name = "nomeExercicio")
	@ApiModelProperty(notes = "Nome do exercício")
	private String nometeste;

	@Column(name = "resumo")
	@ApiModelProperty(notes = "Resumo do exercício")
	private String resumo;

	@Lob
	@Column(name = "Arquivo")
	@ApiModelProperty(notes = "Arquivo do exercício")
	private byte[] arquivo;

	@Column(name = "linkgit")
	@ApiModelProperty(notes = "Link do github do exercício")
	private String linkgit;

	@Column(name = "equipe")
	@ApiModelProperty(notes = "Equipe referente ao exercício")
	private String equipe;
}

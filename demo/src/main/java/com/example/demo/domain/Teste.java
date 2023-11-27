package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teste")
@Getter
@Setter
public class Teste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nometeste")
	@NotBlank(message = "Nome do teste não pode ficar em branco!")
	@Size(min = 0, max = 100, message = "Entrada do nome do teste inválida!(Deve conter no máximo 100 caracteres)")
	private String nometeste;

	@Column(name = "resumo")
	@Size(min = 0, max = 700, message = "Entrada do resumo inválido!(Deve conter no máximo 700 caracteres)")
	private String resumo;

	@Lob
	@Column(name = "Arquivo")
	private byte[] arquivo;

	@Column(name = "linkgit")
	@Size(min = 0, max = 70, message = "Entrada do link inválido!(Deve conter no máximo 70 caracteres)")
	private String linkgit;

	@Column(name = "equipe")
	@NotBlank(message = "Nome da equipe não pode ficar em branco!")
	@Size(min = 0, max = 50, message = "Entrada da equipe inválido!(Deve conter no máximo 50 caracteres)")
	private String equipe;
}

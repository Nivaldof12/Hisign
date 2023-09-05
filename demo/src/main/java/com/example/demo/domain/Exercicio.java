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

@Entity
@Table(name = "teste")
@Getter
@Setter
public class Exercicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nometeste")
	private String nometeste;

	@Column(name = "resumo")
	private String resumo;

	@Lob
	@Column(name = "Arquivo")
	private byte[] arquivo;

	@Column(name = "linkgit")
	private String linkgit;

	@Column(name = "equipe")
	private String equipe;
}

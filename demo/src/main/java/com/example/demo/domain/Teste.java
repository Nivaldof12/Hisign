package com.example.demo.domain;

import lombok.*;

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
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nometeste")
    private String nometeste;
    
    @Column(name = "resumo")
    private String resumo;

	@Column(name = "linkgit")
	private String linkgit;

	@Column(name = "equipe")
	private String equipe;

	private String docName;
	private String docType;

	@Lob
    private byte[] data;


	public Teste(String docName, String contentType, byte[] data) {
		this.docName = docName;
		this.docType = contentType;
		this.data = data;
	}
}

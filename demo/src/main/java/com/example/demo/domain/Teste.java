package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nometeste")
    private String nometeste;
    
    @Column(name = "resumo")
    private String resumo;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Column(name = "linkgit")
    private String linkgit;
    
    @Column(name = "equipe")
    private String equipe;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNometeste() {
		return nometeste;
	}

	public void setNometeste(String nometeste) {
		this.nometeste = nometeste;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getLinkgit() {
		return linkgit;
	}

	public void setLinkgit(String linkgit) {
		this.linkgit = linkgit;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
}

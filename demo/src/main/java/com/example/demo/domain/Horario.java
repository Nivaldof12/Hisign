package com.example.demo.domain;

import javax.persistence.*;

@Entity
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
    private Double horariototaldiario;

    @Column(name = "horas_trabalhadas_semana")
    private Double horariototalsemanal;
    
    @Column(name = "empresa")
    private String empresa;
    
    @Column(name = "setor")
    private String setor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public Double getHorariototaldiario() {
		return horariototaldiario;
	}

	public void setHorariototaldiario(Double horariototaldiario) {
		this.horariototaldiario = horariototaldiario;
	}

	public Double getHorariototalsemanal() {
		return horariototalsemanal;
	}

	public void setHorariototalsemanal(Double horariototalsemanal) {
		this.horariototalsemanal = horariototalsemanal;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}	
}
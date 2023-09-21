package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Campos referentes a horários dos candidatos")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Identificador único do horário")
	private Integer id;

	@Column(name = "nomecompleto")
	@ApiModelProperty(notes = "Nome completo do candidato // Temporario Ate a chegada do usuario")
	private String nomecompleto;

	@Column(name = "entrada_Segunda")
	@ApiModelProperty(notes = "Entrada do candidato na segunda")
	private String entrada_Segunda;

	@Column(name = "intervalo_Segunda")
	@ApiModelProperty(notes = "Intervalo do candidato na segunda")
	private String intervalo_Segunda;

	@Column(name = "saida_Segunda")
	@ApiModelProperty(notes = "Saida do candidato na segunda")
	private String saida_Segunda;
	
	@Column(name = "horas_dia_Segunda")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato na segunda")
	private Double horas_dia_Segunda;

	@Column(name = "entrada_Terca")
	@ApiModelProperty(notes = "Entrada do candidato na terça")
	private String entrada_Terca;

	@Column(name = "intervalo_Terca")
	@ApiModelProperty(notes = "Intervalo do candidato na terça")
	private String intervalo_Terca;

	@Column(name = "saida_Terca")
	@ApiModelProperty(notes = "Saida do candidato na terça")
	private String saida_Terca;
	
	@Column(name = "horas_dia_Terca")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato na terça")
	private Double horas_dia_Terca;

	@Column(name = "entrada_Quarta")
	@ApiModelProperty(notes = "Entrada do candidato na quarta")
	private String entrada_Quarta;

	@Column(name = "intervalo_Quarta")
	@ApiModelProperty(notes = "Intervalo do candidato na quarta")
	private String intervalo_Quarta;

	@Column(name = "saida_Quarta")
	@ApiModelProperty(notes = "Saida do candidato na quarta")
	private String saida_Quarta;
	
	@Column(name = "horas_dia_Quarta")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato na quarta")
	private Double horas_dia_Quarta;

	@Column(name = "entrada_Quinta")
	@ApiModelProperty(notes = "Entrada do candidato na quinta")
	private String entrada_Quinta;

	@Column(name = "intervalo_Quinta")
	@ApiModelProperty(notes = "Intervalo do candidato na quinta")
	private String intervalo_Quinta;

	@Column(name = "saida_Quinta")
	@ApiModelProperty(notes = "Saida do candidato na quinta")
	private String saida_Quinta;
	
	@Column(name = "horas_dia_Quinta")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato na quinta")
	private Double horas_dia_Quinta;

	@Column(name = "entrada_Sexta")
	@ApiModelProperty(notes = "Entrada do candidato na sexta")
	private String entrada_Sexta;

	@Column(name = "intervalo_Sexta")
	@ApiModelProperty(notes = "Intervalo do candidato na sexta")
	private String intervalo_Sexta;

	@Column(name = "saida_Sexta")
	@ApiModelProperty(notes = "Saida do candidato na sexta")
	private String saida_Sexta;
	
	@Column(name = "horas_dia_Sexta")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato na sexta")
	private Double horas_dia_Sexta;

	@Column(name = "entrada_Sabado")
	@ApiModelProperty(notes = "Entrada do candidato no sabado")
	private String entrada_Sabado;

	@Column(name = "intervalo_Sabado")
	@ApiModelProperty(notes = "Intervalo do candidato no sabado")
	private String intervalo_Sabado;

	@Column(name = "saida_Sabado")
	@ApiModelProperty(notes = "Saida do candidato no sabado")
	private String saida_Sabado;
	
	@Column(name = "horas_dia_Sabado")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato no sabado")
	private Double horas_dia_Sabado;

	@Column(name = "observacao")
	@ApiModelProperty(notes = "Observação do candidato se necessario")
	private String observacao;

	@Column(name = "turno")
	@ApiModelProperty(notes = "Turno em que o candidato trabalha")
	private String turno;

	@Column(name = "horas_trabalhadas_semana")
	@ApiModelProperty(notes = "Horas trabalhadas do candidato na semana")
	private Double horariototalsemanal;

	@Column(name = "empresa")
	@ApiModelProperty(notes = "Empresa em que o candidato se candidatou")
	private String empresa;

	@Column(name = "setor")
	private String setor;
	
	// Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getEntrada_Segunda() {
		return entrada_Segunda;
	}

	public void setEntrada_Segunda(String entrada_Segunda) {
		this.entrada_Segunda = entrada_Segunda;
	}

	public String getIntervalo_Segunda() {
		return intervalo_Segunda;
	}

	public void setIntervalo_Segunda(String intervalo_Segunda) {
		this.intervalo_Segunda = intervalo_Segunda;
	}

	public String getSaida_Segunda() {
		return saida_Segunda;
	}

	public void setSaida_Segunda(String saida_Segunda) {
		this.saida_Segunda = saida_Segunda;
	}

	public Double getHoras_dia_Segunda() {
		return horas_dia_Segunda;
	}

	public void setHoras_dia_Segunda(Double horas_dia_Segunda) {
		this.horas_dia_Segunda = horas_dia_Segunda;
	}

	public String getEntrada_Terca() {
		return entrada_Terca;
	}

	public void setEntrada_Terca(String entrada_Terca) {
		this.entrada_Terca = entrada_Terca;
	}

	public String getIntervalo_Terca() {
		return intervalo_Terca;
	}

	public void setIntervalo_Terca(String intervalo_Terca) {
		this.intervalo_Terca = intervalo_Terca;
	}

	public String getSaida_Terca() {
		return saida_Terca;
	}

	public void setSaida_Terca(String saida_Terca) {
		this.saida_Terca = saida_Terca;
	}

	public Double getHoras_dia_Terca() {
		return horas_dia_Terca;
	}

	public void setHoras_dia_Terca(Double horas_dia_Terca) {
		this.horas_dia_Terca = horas_dia_Terca;
	}

	public String getEntrada_Quarta() {
		return entrada_Quarta;
	}

	public void setEntrada_Quarta(String entrada_Quarta) {
		this.entrada_Quarta = entrada_Quarta;
	}

	public String getIntervalo_Quarta() {
		return intervalo_Quarta;
	}

	public void setIntervalo_Quarta(String intervalo_Quarta) {
		this.intervalo_Quarta = intervalo_Quarta;
	}

	public String getSaida_Quarta() {
		return saida_Quarta;
	}

	public void setSaida_Quarta(String saida_Quarta) {
		this.saida_Quarta = saida_Quarta;
	}

	public Double getHoras_dia_Quarta() {
		return horas_dia_Quarta;
	}

	public void setHoras_dia_Quarta(Double horas_dia_Quarta) {
		this.horas_dia_Quarta = horas_dia_Quarta;
	}

	public String getEntrada_Quinta() {
		return entrada_Quinta;
	}

	public void setEntrada_Quinta(String entrada_Quinta) {
		this.entrada_Quinta = entrada_Quinta;
	}

	public String getIntervalo_Quinta() {
		return intervalo_Quinta;
	}

	public void setIntervalo_Quinta(String intervalo_Quinta) {
		this.intervalo_Quinta = intervalo_Quinta;
	}

	public String getSaida_Quinta() {
		return saida_Quinta;
	}

	public void setSaida_Quinta(String saida_Quinta) {
		this.saida_Quinta = saida_Quinta;
	}

	public Double getHoras_dia_Quinta() {
		return horas_dia_Quinta;
	}

	public void setHoras_dia_Quinta(Double horas_dia_Quinta) {
		this.horas_dia_Quinta = horas_dia_Quinta;
	}

	public String getEntrada_Sexta() {
		return entrada_Sexta;
	}

	public void setEntrada_Sexta(String entrada_Sexta) {
		this.entrada_Sexta = entrada_Sexta;
	}

	public String getIntervalo_Sexta() {
		return intervalo_Sexta;
	}

	public void setIntervalo_Sexta(String intervalo_Sexta) {
		this.intervalo_Sexta = intervalo_Sexta;
	}

	public String getSaida_Sexta() {
		return saida_Sexta;
	}

	public void setSaida_Sexta(String saida_Sexta) {
		this.saida_Sexta = saida_Sexta;
	}

	public Double getHoras_dia_Sexta() {
		return horas_dia_Sexta;
	}

	public void setHoras_dia_Sexta(Double horas_dia_Sexta) {
		this.horas_dia_Sexta = horas_dia_Sexta;
	}

	public String getEntrada_Sabado() {
		return entrada_Sabado;
	}

	public void setEntrada_Sabado(String entrada_Sabado) {
		this.entrada_Sabado = entrada_Sabado;
	}

	public String getIntervalo_Sabado() {
		return intervalo_Sabado;
	}

	public void setIntervalo_Sabado(String intervalo_Sabado) {
		this.intervalo_Sabado = intervalo_Sabado;
	}

	public String getSaida_Sabado() {
		return saida_Sabado;
	}

	public void setSaida_Sabado(String saida_Sabado) {
		this.saida_Sabado = saida_Sabado;
	}

	public Double getHoras_dia_Sabado() {
		return horas_dia_Sabado;
	}

	public void setHoras_dia_Sabado(Double horas_dia_Sabado) {
		this.horas_dia_Sabado = horas_dia_Sabado;
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
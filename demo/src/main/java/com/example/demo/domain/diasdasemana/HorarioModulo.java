package com.example.demo.domain.diasdasemana;

import javax.persistence.*;

@Entity
@Table(name = "horario_modulo")
public class HorarioModulo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "horario_entrada")
    private String horario_entrada;

    @Column(name = "horario_intervalo")
    private String horario_intevalo;

    @Column(name = "horario_saida")
    private String horario_saida;

    @Column(name = "Dia_da_semana")
    private String Dia_da_semana;

}

package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Lob;

@Entity
@Table(name = "tceadicionar")
@Getter
@Setter
public class Tce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob 
    @Column(name = "Arquivo")
    private byte[] arquivo;

    @Column(name = "nomecompleto")
    private String nomecompleto;
}

package com.weg.SOLID_Projeto.refatorado.domain.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private double valor;

    public Flor(String nome, String tipo, double valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }
}

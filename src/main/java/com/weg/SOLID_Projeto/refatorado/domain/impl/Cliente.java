package com.weg.SOLID_Projeto.refatorado.domain.impl;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String telefone;

    public Cliente(String nome, String tipo, String telefone) {
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
    }
}

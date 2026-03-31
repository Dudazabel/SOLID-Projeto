package com.weg.SOLID_Projeto.refatorado.domain.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compra")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nomeCliente;

    @Column(nullable = false)
    private String nomeFlor;

    @Column(nullable = false)
    private int quantidadeFlores;

    @Column(nullable = false)
    private String nomeServico;

    @Column(nullable = false)
    private double valorTotal;

    public Compra(String nomeCliente, String nomeFlor, int quantidadeFlores, String nomeServico) {
        this.nomeCliente = nomeCliente;
        this.nomeFlor = nomeFlor;
        this.quantidadeFlores = quantidadeFlores;
        this.nomeServico = nomeServico;
    }
}

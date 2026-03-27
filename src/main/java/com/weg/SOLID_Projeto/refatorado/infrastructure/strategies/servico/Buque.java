package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.servico;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.servico.AdicionalPorServico;

public class Buque implements AdicionalPorServico {

    @Override
    public double calcular(double valor){
        return valor + ( valor * 0.20 );
    }
}

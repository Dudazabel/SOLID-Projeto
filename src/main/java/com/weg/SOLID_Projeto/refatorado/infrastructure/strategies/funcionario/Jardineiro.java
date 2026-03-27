package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.funcionario;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.funcionario.AdicionalSalarialPorPericulosidade;

public class Jardineiro implements AdicionalSalarialPorPericulosidade {

    @Override
    public double calcular(double valor){
        return valor + (valor * 0.20);
    }
}

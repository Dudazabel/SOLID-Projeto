package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.servico;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.servico.AdicionalPorServico;
import org.springframework.stereotype.Component;

@Component
public class Festa implements AdicionalPorServico {

    @Override
    public double calcular(double valor){
        return valor + (valor * 0.25);
    }

    @Override
    public String getTipo(){
        return "FESTA";
    }

}

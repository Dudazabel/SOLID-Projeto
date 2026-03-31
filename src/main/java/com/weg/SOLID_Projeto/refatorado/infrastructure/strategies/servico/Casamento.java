package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.servico;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.servico.AdicionalPorServico;
import org.springframework.stereotype.Component;

@Component
public class Casamento implements AdicionalPorServico {

    @Override
    public double calcular(double valor){
        return valor + (valor * 0.30);
    }

    @Override
    public String getTipo(){
        return "CASAMENTO";
    }
}

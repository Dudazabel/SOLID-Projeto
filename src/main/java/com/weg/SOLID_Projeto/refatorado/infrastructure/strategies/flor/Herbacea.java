package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.flor;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.flor.AdicionalRaridade;
import org.springframework.stereotype.Component;

@Component
public class Herbacea implements AdicionalRaridade {

    @Override
    public double calcular(double valor){
        return valor;
    }

    @Override
    public String getTipo(){
        return "HERBACEA";
    }
}

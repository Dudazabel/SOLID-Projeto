package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.flor;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.flor.AdicionalRaridade;
import org.springframework.stereotype.Component;

@Component
public class Arbusto implements AdicionalRaridade {

    @Override
    public double calcular(double valor){
        return valor * 1.10;
    }

    @Override
    public String getTipo(){
        return "ARBUSTO";
    }
}

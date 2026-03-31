package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.funcionario;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.funcionario.AdicionalSalarialPorPericulosidade;
import org.springframework.stereotype.Component;

@Component
public class Atendente implements AdicionalSalarialPorPericulosidade {

    @Override
    public double calcular(double valor){
        return valor;
    }
}

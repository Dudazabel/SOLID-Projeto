package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.cliente;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.cliente.DescontoTipoCliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteVIP implements DescontoTipoCliente {

    @Override
    public double calcular(double valor){
        return valor * 0.90;
    }
}

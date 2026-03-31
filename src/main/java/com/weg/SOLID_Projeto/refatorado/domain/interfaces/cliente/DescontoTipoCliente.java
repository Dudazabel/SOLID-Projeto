package com.weg.SOLID_Projeto.refatorado.domain.interfaces.cliente;

public interface DescontoTipoCliente {
    double calcular(double valor);
    String getTipo();
}

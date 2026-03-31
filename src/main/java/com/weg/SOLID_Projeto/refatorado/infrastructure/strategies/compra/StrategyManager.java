package com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.compra;

import com.weg.SOLID_Projeto.refatorado.domain.interfaces.cliente.DescontoTipoCliente;
import com.weg.SOLID_Projeto.refatorado.domain.interfaces.flor.AdicionalRaridade;
import com.weg.SOLID_Projeto.refatorado.domain.interfaces.servico.AdicionalPorServico;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StrategyManager {

    private final Map<String, DescontoTipoCliente> descCliente = new HashMap<>();
    private final Map<String, AdicionalRaridade> adicRaridade = new HashMap<>();
    private final Map<String, AdicionalPorServico> adicServico = new HashMap<>();

    public StrategyManager(List<DescontoTipoCliente> listaDescCliente,
                           List<AdicionalRaridade> listaAdicRaridade,
                           List<AdicionalPorServico> listaAdicServico){

        listaDescCliente.forEach(desconto -> descCliente.put(desconto.getTipo().toUpperCase(), desconto));
        listaAdicRaridade.forEach(raridade -> adicRaridade.put(raridade.getTipo().toUpperCase(), raridade));
        listaAdicServico.forEach(servico -> adicServico.put(servico.getTipo().toUpperCase(), servico));
    }

    public DescontoTipoCliente getDesconto(String tipo){
        return descCliente.getOrDefault(tipo.toUpperCase(), descCliente.get("NORMAL"));
    }

    public AdicionalRaridade getAdcRaridade(String tipo){
        return adicRaridade.getOrDefault(tipo.toUpperCase(), adicRaridade.get("HERBACEA"));
    }

    public AdicionalPorServico getAdcPorServico(String tipo){
        return adicServico.getOrDefault(tipo.toUpperCase(), adicServico.get("BUQUE"));
    }
}

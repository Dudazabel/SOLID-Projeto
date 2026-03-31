package com.weg.SOLID_Projeto.refatorado.service.mapper;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Compra;
import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRespostaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraMapper {

    public Compra DTOParaEntidade(CompraRequisicaoDTO compra){
        return new Compra(compra.nomeCliente(), compra.nomeFlor(), compra.quantidadeFlores(), compra.nomeServico());
    }

    public CompraRespostaDTO EntidadeParaDTO(Compra compra){
        return new CompraRespostaDTO(compra.getId(), compra.getNomeCliente(), compra.getNomeFlor(), compra.getQuantidadeFlores(), compra.getNomeServico(), compra.getValorTotal());
    }

    public List<CompraRespostaDTO> EntidadeParaDTOList(List<Compra> compras){
        return compras
                .stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}

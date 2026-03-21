package com.weg.SOLID_Projeto.refatorado.service.mapper;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Flor;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRespostaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlorMapper {

    public Flor DTOParaEntidade(FlorRespostaDTO flor){
        return new Flor(flor.nome(), flor.tipo(), flor.valor());
    }

    public FlorRespostaDTO EntidadeParaDTO(Flor flor){
        return new FlorRespostaDTO(flor.getId(), flor.getNome(), flor.getTipo(), flor.getValor());
    }

    public List<FlorRespostaDTO> EntidadeParaDTOList(List<Flor> flores){
        return flores.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}

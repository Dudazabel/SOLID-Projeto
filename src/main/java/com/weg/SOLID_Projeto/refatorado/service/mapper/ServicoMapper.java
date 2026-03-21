package com.weg.SOLID_Projeto.refatorado.service.mapper;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Servico;
import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRespostaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoMapper {

    public Servico DTOParaEntidade(ServicoRequisicaoDTO servico){
        return new Servico(servico.nome(), servico.tipo(), servico.valor());
    }

    public ServicoRespostaDTO EntidadeParaDTO(Servico servico){
        return new ServicoRespostaDTO(servico.getId(), servico.getNome(), servico.getTipo(), servico.getValor());
    }

    public List<ServicoRespostaDTO> EntidadeParaDTOLista(List<Servico> servicos){
        return servicos.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}

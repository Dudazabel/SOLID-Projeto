package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Flor;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.FlorRepository;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.mapper.FlorMapper;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface.FlorServiceIntrf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlorServiceImpl implements FlorServiceIntrf {

    private final FlorMapper mapper;
    private final FlorRepository repository;

    @Override
    public FlorRespostaDTO cadastrarFlor(FlorRequisicaoDTO flor){
        Flor florSalva = mapper.DTOParaEntidade(flor);
        return mapper.EntidadeParaDTO(repository.save(florSalva));
    }
}

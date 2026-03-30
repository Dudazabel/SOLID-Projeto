package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Flor;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.FlorRepository;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.mapper.FlorMapper;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface.FlorServiceIntrf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public FlorRespostaDTO atualizarFlor(FlorRequisicaoDTO flor, Long id){
        Flor florSalva = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID indicado não foi encontrado!"));
        florSalva.setNome(flor.nome());
        florSalva.setTipo(flor.tipo());
        florSalva.setValor(flor.valor());
        return mapper.EntidadeParaDTO(repository.save(florSalva));
    }

    @Override
    public List<FlorRespostaDTO> listarFlores(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    @Override
    public FlorRespostaDTO buscarFlorPorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o nome indicado!")));
    }

    @Override
    public void deletarFlor(Long id){
        repository.deleteById(id);
    }
}

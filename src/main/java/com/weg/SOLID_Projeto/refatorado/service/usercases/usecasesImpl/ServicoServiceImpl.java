package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Servico;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.ServicoRepository;
import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.mapper.ServicoMapper;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface.ServicoServiceIntrf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicoServiceImpl implements ServicoServiceIntrf {

    private final ServicoMapper mapper;
    private final ServicoRepository repository;

    @Override
    public ServicoRespostaDTO criarServico(ServicoRequisicaoDTO servico){
        Servico servicoSalvo = mapper.DTOParaEntidade(servico);
        return mapper.EntidadeParaDTO(repository.save(servicoSalvo));
    }

    @Override
    public ServicoRespostaDTO atualizarServico(ServicoRequisicaoDTO servico, Long id){
        Servico servicoSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID indicado não foi encontrado!"));
        servicoSalvo.setNome(servico.nome());
        servicoSalvo.setTipo(servico.tipo());
        servicoSalvo.setValor(servico.valor());
        return mapper.EntidadeParaDTO(repository.save(servicoSalvo));
    }

    @Override
    public List<ServicoRespostaDTO> listarServicos(){
        return mapper.EntidadeParaDTOLista(repository.findAll());
    }

    @Override
    public ServicoRespostaDTO buscarServicoPorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("O nome informado não foi encontrado!")));
    }

    @Override
    public void deletarServico(Long id){
        repository.deleteById(id);
    }
}

package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Funcionario;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.FuncionarioRepository;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.mapper.FuncionarioMapper;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface.FuncionarioServiceIntrf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FuncionarioServiceImpl implements FuncionarioServiceIntrf {

    private final FuncionarioMapper mapper;
    private final FuncionarioRepository repository;

    @Override
    public FuncionarioRespostaDTO cadastrarFuncionario(FuncionarioRequisicaoDTO funcionario){
        Funcionario funcionarioSalvo = mapper.DTOParaEntidade(funcionario);
        return mapper.EntidadeParaDTO(repository.save(funcionarioSalvo));
    }

    @Override
    public FuncionarioRespostaDTO atualizarFuncionario(FuncionarioRequisicaoDTO funcionario, Long id){
        Funcionario funcionarioSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID informado não foi encontrado!"));
        funcionarioSalvo.setNome(funcionario.nome());
        funcionarioSalvo.setTipo(funcionario.tipo());
        funcionarioSalvo.setSalario(funcionario.salario());
        return mapper.EntidadeParaDTO(repository.save(funcionarioSalvo));
    }

    @Override
    public List<FuncionarioRespostaDTO> listarFuncionarios(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    @Override
    public FuncionarioRespostaDTO buscarFuncionarioPorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("O nome informado não foi encontrado!")));
    }

    @Override
    public void deletarFuncionario(Long id){
        repository.deleteById(id);
    }
}

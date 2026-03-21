package com.weg.SOLID_Projeto.refatorado.service.mapper;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Funcionario;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRespostaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionarioMapper {

    public Funcionario DTOParaEntidade(FuncionarioRequisicaoDTO funcionario){
        return new Funcionario(funcionario.nome(), funcionario.tipo(), funcionario.salario());
    }

    public FuncionarioRespostaDTO EntidadeParaDTO(Funcionario funcionario){
        return new FuncionarioRespostaDTO(funcionario.getId(), funcionario.getNome(), funcionario.getTipo(), funcionario.getSalario());
    }

    public List<FuncionarioRespostaDTO> EntidadeParaDTOList(List<Funcionario> funcionarios){
        return funcionarios.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}

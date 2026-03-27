package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Funcionario;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRespostaDTO;

import java.util.List;

public interface FuncionarioServiceIntrf {

    FuncionarioRespostaDTO cadastrarFuncionario(FuncionarioRequisicaoDTO funcionario);

    FuncionarioRespostaDTO atualizarFuncionario(FuncionarioRequisicaoDTO funcionario, Long id);

    List<FuncionarioRespostaDTO> listarFuncionarios();

    FuncionarioRespostaDTO buscarFuncionarioPorNome(String nome);

    void deletarFuncionario(Long id);
}

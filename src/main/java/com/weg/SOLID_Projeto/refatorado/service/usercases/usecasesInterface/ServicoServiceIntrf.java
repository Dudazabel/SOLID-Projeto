package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface;

import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRespostaDTO;

import java.util.List;

public interface ServicoServiceIntrf {

    ServicoRespostaDTO criarServico(ServicoRequisicaoDTO servico);

    ServicoRespostaDTO atualizarServico(ServicoRequisicaoDTO servico, Long id);

    List<ServicoRespostaDTO> listarServicos();

    ServicoRespostaDTO buscarServicoPorNome(String nome);

    void deletarServico(Long id);
}

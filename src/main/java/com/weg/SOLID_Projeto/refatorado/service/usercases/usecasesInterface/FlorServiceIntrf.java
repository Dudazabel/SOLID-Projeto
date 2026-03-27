package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Flor;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRespostaDTO;

import java.util.List;

public interface FlorServiceIntrf {

    FlorRespostaDTO cadastrarFlor(FlorRequisicaoDTO flor);

    FlorRespostaDTO atualizarFlor(FlorRequisicaoDTO flor, Long id);

    List<FlorRespostaDTO> listarFlores();

    FlorRespostaDTO buscarFlorPorNome(String nome);

    void deletarFlor(Long id);
}

package com.weg.SOLID_Projeto.refatorado.service.dto.servico;

public record ServicoRespostaDTO(
        Long id,
        String nome,
        String tipo,
        double valor
) {
}

package com.weg.SOLID_Projeto.refatorado.service.dto.servico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServicoRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String tipo,
        @NotNull
        double valor
) {
}

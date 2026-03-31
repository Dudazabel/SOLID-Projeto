package com.weg.SOLID_Projeto.refatorado.service.dto.flor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FlorRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String tipo,
        @NotNull
        double valor
) {
}

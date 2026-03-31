package com.weg.SOLID_Projeto.refatorado.service.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String tipo,
        @NotBlank
        String telefone
) {
}

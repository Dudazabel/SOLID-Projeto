package com.weg.SOLID_Projeto.refatorado.service.dto.compra;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompraRequisicaoDTO(
        @NotBlank
        String nomeCliente,
        @NotBlank
        String nomeFlor,
        @NotNull
        int quantidadeFlores,
        @NotBlank
        String nomeServico
) {
}

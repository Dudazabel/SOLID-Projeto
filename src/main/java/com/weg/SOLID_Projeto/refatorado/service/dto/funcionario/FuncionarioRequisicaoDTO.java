package com.weg.SOLID_Projeto.refatorado.service.dto.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioRequisicaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String tipo,
        @NotNull
        double salario
) {
}

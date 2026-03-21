package com.weg.SOLID_Projeto.refatorado.service.dto.funcionario;

public record FuncionarioRespostaDTO(
        Long id,
        String nome,
        String tipo,
        double salario
) {
}

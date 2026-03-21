package com.weg.SOLID_Projeto.refatorado.service.dto.cliente;

public record ClienteRespostaDTO(
        Long id,
        String nome,
        String tipo,
        String telefone
) {
}

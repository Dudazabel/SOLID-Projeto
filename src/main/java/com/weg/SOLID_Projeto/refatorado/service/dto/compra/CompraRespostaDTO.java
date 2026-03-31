package com.weg.SOLID_Projeto.refatorado.service.dto.compra;

public record CompraRespostaDTO(
        Long id,
        String nomeCliente,
        String nomeFlor,
        int quantidadeFlores,
        String nomeServico,
        double valorTotal
) {
}

package com.weg.SOLID_Projeto.refatorado.controller;

import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl.CompraServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compra")
public class CompraController {

    private final CompraServiceImpl service;

    @PostMapping
    public CompraRespostaDTO realizarCompra(@Valid @RequestBody CompraRequisicaoDTO compra){
        return service.realizarCompra(compra);
    }
}

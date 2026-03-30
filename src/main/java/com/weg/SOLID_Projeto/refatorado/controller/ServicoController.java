package com.weg.SOLID_Projeto.refatorado.controller;

import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl.ServicoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoServiceImpl service;

    @PostMapping
    public ServicoRespostaDTO

}

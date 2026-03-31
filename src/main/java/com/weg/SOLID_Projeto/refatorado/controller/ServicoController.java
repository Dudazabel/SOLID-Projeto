package com.weg.SOLID_Projeto.refatorado.controller;

import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.servico.ServicoRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl.ServicoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servico")
public class ServicoController {

    private final ServicoServiceImpl service;

    @PostMapping
    public ServicoRespostaDTO criarServico(@Valid @RequestBody ServicoRequisicaoDTO servico){
        return service.criarServico(servico);
    }

    @PutMapping("/{id}")
    public ServicoRespostaDTO atualizarServico(@Valid @RequestBody ServicoRequisicaoDTO servico, @PathVariable Long id){
        return service.atualizarServico(servico, id);
    }

    @GetMapping
    public List<ServicoRespostaDTO> listarServicos(){
        return service.listarServicos();
    }

    @GetMapping("/nome/{nome}")
    public ServicoRespostaDTO buscarServicoPorNome(@Valid @PathVariable String nome){
        return service.buscarServicoPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletarServico(@Valid @PathVariable Long id){
        service.deletarServico(id);
    }

}

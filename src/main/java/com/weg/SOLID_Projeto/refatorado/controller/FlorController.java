package com.weg.SOLID_Projeto.refatorado.controller;

import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.flor.FlorRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl.FlorServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flor")
public class FlorController {

    private final FlorServiceImpl service;

    @PostMapping
    public FlorRespostaDTO cadastrarFlor(@Valid @RequestBody FlorRequisicaoDTO flor){
        return service.cadastrarFlor(flor);
    }

    @PutMapping("/{id}")
    public FlorRespostaDTO atualizarFlor(@Valid @RequestBody FlorRequisicaoDTO flor, @PathVariable Long id){
        return service.atualizarFlor(flor, id);
    }

    @GetMapping
    public List<FlorRespostaDTO> listarFlores(){
        return service.listarFlores();
    }

    @GetMapping("/nome/{nome}")
    public FlorRespostaDTO buscarFlorPorNome(@Valid @PathVariable String nome){
        return service.buscarFlorPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletarFlor(@Valid @PathVariable Long id){
        service.deletarFlor(id);
    }
}

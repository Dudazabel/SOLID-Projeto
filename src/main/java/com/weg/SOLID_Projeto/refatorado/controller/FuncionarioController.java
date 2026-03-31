package com.weg.SOLID_Projeto.refatorado.controller;

import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.funcionario.FuncionarioRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl.FuncionarioServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioServiceImpl service;

    @PostMapping
    public FuncionarioRespostaDTO cadastrarFuncionario(@Valid @RequestBody FuncionarioRequisicaoDTO funcionario){
        return service.cadastrarFuncionario(funcionario);
    }

    @PutMapping("/{id}")
    public FuncionarioRespostaDTO atualizarFuncionario(@Valid @RequestBody FuncionarioRequisicaoDTO funcionario, @PathVariable Long id){
        return service.atualizarFuncionario(funcionario, id);
    }

    @GetMapping
    public List<FuncionarioRespostaDTO> listarFuncionarios(){
        return service.listarFuncionarios();
    }

    @GetMapping("/nome/{nome}")
    public FuncionarioRespostaDTO buscarFuncionariosPorNome(@Valid @PathVariable String nome){
        return service.buscarFuncionarioPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@Valid @PathVariable Long id){
        service.deletarFuncionario(id);
    }
}

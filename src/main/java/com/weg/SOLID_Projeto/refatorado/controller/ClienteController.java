package com.weg.SOLID_Projeto.refatorado.controller;

import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl.ClienteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteServiceImpl service;

    @PostMapping
    public ClienteRespostaDTO cadastrarCliente(@Valid @RequestBody ClienteRequisicaoDTO cliente){
        return service.cadastrarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ClienteRespostaDTO atualizarCliente(@Valid @RequestBody ClienteRequisicaoDTO cliente, @PathVariable Long id){
        return service.atualizarCliente(cliente, id);
    }

    @GetMapping
    public List<ClienteRespostaDTO> listarClientes(){
        return service.listarClientes();
    }

    @GetMapping("/nome/{nome}")
    public ClienteRespostaDTO buscarClientePorNome(@Valid @PathVariable String nome){
        return service.buscarClientePorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@Valid @PathVariable Long id){
        service.deletarCliente(id);
    }
}

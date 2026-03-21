package com.weg.SOLID_Projeto.refatorado.service.mapper;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Cliente;
import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRespostaDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    public Cliente DTOParaEntidade (ClienteRequisicaoDTO clliente){
        return new Cliente(clliente.nome(), clliente.tipo(), clliente.telefone());
    }

    public ClienteRespostaDTO EntidadeParaDTO(Cliente cliente){
        return new ClienteRespostaDTO(cliente.getId(), cliente.getNome(), cliente.getTipo(), cliente.getTelefone());
    }

    public List<ClienteRespostaDTO> EntidadeParaDTOList(List<Cliente> clientes){
        return clientes.stream()
                .map(this::EntidadeParaDTO)
                .toList();
    }
}

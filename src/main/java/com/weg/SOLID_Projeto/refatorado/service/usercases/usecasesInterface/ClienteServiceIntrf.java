package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface;

import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRespostaDTO;

import java.util.List;

public interface ClienteServiceIntrf {

    ClienteRespostaDTO cadastrarCliente(ClienteRequisicaoDTO cliente);

    ClienteRespostaDTO atualizarCliente(ClienteRequisicaoDTO cliente, Long id);

    List<ClienteRespostaDTO> listarClientes();

    ClienteRespostaDTO buscarClientePorNome(String nome);

    void deletarCliente(Long id);
}

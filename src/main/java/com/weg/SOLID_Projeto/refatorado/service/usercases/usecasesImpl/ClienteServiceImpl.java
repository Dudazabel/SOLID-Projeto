package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Cliente;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.ClienteRepository;
import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.cliente.ClienteRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.mapper.ClienteMapper;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface.ClienteServiceIntrf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteServiceIntrf {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    @Override
    public ClienteRespostaDTO cadastrarCliente(ClienteRequisicaoDTO cliente){
        Cliente clienteSalvo = mapper.DTOParaEntidade(cliente);
        return mapper.EntidadeParaDTO(repository.save(clienteSalvo));
    }

    @Override
    public ClienteRespostaDTO atualizarCliente(ClienteRequisicaoDTO cliente, Long id){
        Cliente clienteSalvo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O ID indicado não foi encontrado!"));
        clienteSalvo.setNome(cliente.nome());
        clienteSalvo.setTipo(cliente.tipo());
        clienteSalvo.setTelefone(cliente.telefone());
        return mapper.EntidadeParaDTO(repository.save(clienteSalvo));
    }

    @Override
    public List<ClienteRespostaDTO> listarClientes(){
        return mapper.EntidadeParaDTOList(repository.findAll());
    }

    @Override
    public ClienteRespostaDTO buscarClientePorNome(String nome){
        return mapper.EntidadeParaDTO(repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("O nome indicado não foi encontrado!")));
    }

    @Override
    public void deletarCliente(Long id){
        repository.deleteById(id);
    }
}

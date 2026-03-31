package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesImpl;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Cliente;
import com.weg.SOLID_Projeto.refatorado.domain.impl.Compra;
import com.weg.SOLID_Projeto.refatorado.domain.impl.Flor;
import com.weg.SOLID_Projeto.refatorado.domain.impl.Servico;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.ClienteRepository;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.CompraRepository;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.FlorRepository;
import com.weg.SOLID_Projeto.refatorado.infrastructure.repository.ServicoRepository;
import com.weg.SOLID_Projeto.refatorado.infrastructure.strategies.compra.StrategyManager;
import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRespostaDTO;
import com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface.CompraServiceIntrf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraServiceIntrf {

    private final ClienteRepository clienteRepository;
    private final FlorRepository florRepository;
    private final ServicoRepository servicoRepository;
    private final StrategyManager strategyManager;
    private final CompraRepository compraRepository;


    @Override
    public CompraRespostaDTO realizarCompra(CompraRequisicaoDTO compra){
        Cliente cliente = clienteRepository.findByNome(compra.nomeCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        Flor flor = florRepository.findByNome(compra.nomeFlor())
                .orElseThrow(() -> new RuntimeException("Flor não encontrada!"));
        Servico servico = servicoRepository.findByNome(compra.nomeServico())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado!"));


        double valorBaseFlor = flor.getValor() * compra.quantidadeFlores();
        double totalFlor = strategyManager.getAdcRaridade(flor.getTipo()).calcular(valorBaseFlor);

        double totalServico = strategyManager.getAdcPorServico(servico.getTipo()).calcular(servico.getValor());

        double subtotal = totalFlor + totalServico;

        double total = strategyManager.getDesconto(cliente.getTipo()).calcular(subtotal);

        Compra novaCompra = new Compra();
        novaCompra.setNomeCliente(compra.nomeCliente());
        novaCompra.setNomeFlor(compra.nomeFlor());
        novaCompra.setQuantidadeFlores(compra.quantidadeFlores());
        novaCompra.setNomeServico(compra.nomeServico());
        novaCompra.setValorTotal(total);

        Compra compraSalva = compraRepository.save(novaCompra);

        return new CompraRespostaDTO(compraSalva.getId(), compra.nomeCliente(), compra.nomeFlor(), compra.quantidadeFlores(), compra.nomeServico(), total);
    }
}

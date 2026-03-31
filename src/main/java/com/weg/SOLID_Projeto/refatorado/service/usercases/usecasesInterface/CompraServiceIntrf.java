package com.weg.SOLID_Projeto.refatorado.service.usercases.usecasesInterface;

import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRequisicaoDTO;
import com.weg.SOLID_Projeto.refatorado.service.dto.compra.CompraRespostaDTO;

public interface CompraServiceIntrf {

    CompraRespostaDTO realizarCompra(CompraRequisicaoDTO compra);
}

package com.weg.SOLID_Projeto.refatorado.infrastructure.repository;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

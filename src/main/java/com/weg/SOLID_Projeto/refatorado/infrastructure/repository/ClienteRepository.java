package com.weg.SOLID_Projeto.refatorado.infrastructure.repository;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNome(String nome);
}

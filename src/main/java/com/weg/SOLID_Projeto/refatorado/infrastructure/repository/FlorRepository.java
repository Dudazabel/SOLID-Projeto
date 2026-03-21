package com.weg.SOLID_Projeto.refatorado.infrastructure.repository;

import com.weg.SOLID_Projeto.refatorado.domain.impl.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Long> {
}

package com.br.fiap.smartnature.repository;

import com.br.fiap.smartnature.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {
}

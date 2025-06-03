package com.br.fiap.smartnature.repository;

import com.br.fiap.smartnature.model.LeituraAmbiental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeituraAmbientalRepository extends JpaRepository<LeituraAmbiental, Long> {
}

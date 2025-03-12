package com.doback.E_rank.repository;

import com.doback.E_rank.entity.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {
    List<Desafio> findByStatus(Desafio.StatusDesafio status);
}

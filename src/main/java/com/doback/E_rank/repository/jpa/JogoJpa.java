package com.doback.E_rank.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doback.E_rank.models.Jogos;

public interface JogoJpa extends JpaRepository<Jogos, Integer>{
}

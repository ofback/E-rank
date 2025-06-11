package com.doback.E_rank.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doback.E_rank.infrastructure.models.FeedMensagensModel;

public interface FeedMensagensJpa extends JpaRepository<FeedMensagensModel, Integer>{
}

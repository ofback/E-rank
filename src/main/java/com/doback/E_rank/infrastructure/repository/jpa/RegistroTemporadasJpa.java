package com.doback.E_rank.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.doback.E_rank.infrastructure.models.RegistroTemporadasModel;

public interface RegistroTemporadasJpa extends JpaRepository<RegistroTemporadasModel, Integer> {
}

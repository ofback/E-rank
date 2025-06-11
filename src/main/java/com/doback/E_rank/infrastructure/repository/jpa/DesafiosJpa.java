package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.DesafiosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafiosJpa extends JpaRepository<DesafiosModel, Integer> {
}

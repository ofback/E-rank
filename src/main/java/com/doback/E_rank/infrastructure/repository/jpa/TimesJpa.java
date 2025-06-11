package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.TimesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesJpa extends JpaRepository<TimesModel, Integer> {
}

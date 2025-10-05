package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroTimesJpa extends JpaRepository<RegistroTimesModel, Integer> {
    List<RegistroTimesModel> findByIdUsuarios(int userId);
}
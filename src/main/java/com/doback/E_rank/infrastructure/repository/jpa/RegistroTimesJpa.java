package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RegistroTimesJpa extends JpaRepository<RegistroTimesModel, Integer> {

    List<RegistroTimesModel> findByIdUsuarios(int userId);

    // --- NOVO: Busca membros de um time específico ---
    List<RegistroTimesModel> findByIdTimes(int idTimes);
    // -------------------------------------------------

    Optional<RegistroTimesModel> findByIdTimesAndIdUsuarios(int idTimes, int idUsuarios);

    @Transactional
    void deleteByIdTimesAndIdUsuarios(int idTimes, int idUsuarios);
}
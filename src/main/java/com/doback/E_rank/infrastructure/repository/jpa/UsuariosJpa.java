package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuariosJpa extends JpaRepository<UsuariosModel, Long> {
    Optional<UsuariosModel> findByEmail(String email);
}

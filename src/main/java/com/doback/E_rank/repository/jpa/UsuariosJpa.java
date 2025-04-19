package com.doback.E_rank.repository.jpa;

import com.doback.E_rank.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosJpa extends JpaRepository<UsuariosModel, Long> {
}

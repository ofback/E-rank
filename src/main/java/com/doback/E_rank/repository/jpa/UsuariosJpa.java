package com.doback.E_rank.repository.jpa;

import com.doback.E_rank.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosJpa extends JpaRepository<Usuarios, Long> {  // Usando Long como tipo do ID
}

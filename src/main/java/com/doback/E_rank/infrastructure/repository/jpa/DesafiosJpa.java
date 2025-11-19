// E-rank/src/main/java/com/doback/E_rank/infrastructure/repository/jpa/DesafiosJpa.java
package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.DesafiosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DesafiosJpa extends JpaRepository<DesafiosModel, Integer> {
    // Busca desafios pendentes recebidos pelo usuário
    List<DesafiosModel> findByDesafiadoIdAndStatus(int desafiadoId, String status);
}
// E-rank/src/main/java/com/doback/E_rank/infrastructure/repository/jpa/DesafiosJpa.java
package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.DesafiosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DesafiosJpa extends JpaRepository<DesafiosModel, Integer> {

    List<DesafiosModel> findByDesafiadoIdAndStatus(int desafiadoId, String status);

    // ATUALIZADO: Busca desafios 'A' (Aceitos) OU 'W' (Aguardando Oponente)
    @Query("SELECT d FROM DesafiosModel d WHERE (d.desafianteId = :userId OR d.desafiadoId = :userId) AND (d.status = 'A' OR d.status = 'W')")
    List<DesafiosModel> findAceitosPorUsuario(@Param("userId") int userId);
}
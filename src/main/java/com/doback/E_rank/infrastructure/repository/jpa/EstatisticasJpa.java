// E-rank/src/main/java/com/doback/E_rank/infrastructure/repository/jpa/EstatisticasJpa.java
package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstatisticasJpa extends JpaRepository<EstatisticasModel, Integer> {
    // Correção: findBy + JogosModel + Id + ...
    List<EstatisticasModel> findByJogosModelIdAndStsProvacao(int jogoId, int stsProvacao);

    // Correção: findBy + UsuariosModel + Id + ...
    List<EstatisticasModel> findByUsuariosModelIdAndStsProvacao(int usuarioId, int stsProvacao);
}
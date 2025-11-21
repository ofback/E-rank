// E-rank/src/main/java/com/doback/E_rank/infrastructure/repository/jpa/EstatisticasJpa.java
package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstatisticasJpa extends JpaRepository<EstatisticasModel, Integer> {

    List<EstatisticasModel> findByJogosModelIdAndStsProvacao(int jogoId, int stsProvacao);
    List<EstatisticasModel> findByUsuariosModelIdAndStsProvacao(int usuarioId, int stsProvacao);

    // --- NOVOS MÉTODOS PARA RF10 ---
    // Verifica se ESTE usuário já registrou stats para ESTE desafio
    boolean existsByDesafiosModelIdAndUsuariosModelId(int desafioId, int usuarioId);

    // Conta quantos registros já existem para o desafio (0 ou 1)
    long countByDesafiosModelId(int desafioId);
}
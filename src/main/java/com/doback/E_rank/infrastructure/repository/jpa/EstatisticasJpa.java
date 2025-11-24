package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EstatisticasJpa extends JpaRepository<EstatisticasModel, Integer> {

    List<EstatisticasModel> findByJogosModelIdAndStsProvacao(int jogoId, int stsProvacao);
    List<EstatisticasModel> findByUsuariosModelIdAndStsProvacao(int usuarioId, int stsProvacao);

    // Métodos RF10
    boolean existsByDesafiosModelIdAndUsuariosModelId(int desafioId, int usuarioId);
    long countByDesafiosModelId(int desafioId);

    // --- NOVO MÉTODO PARA RF16 (Ranking Global Paginado) ---
    // Calcula: (Vitórias*10) + (Kills*2) - (Derrotas*3). Ajuste os pesos conforme sua regra.
    @Query("SELECT new com.doback.E_rank.dto.RankingDTO(" +
            "u.nickname, " +
            "SUM((e.vitorias * 10) + (e.kills * 2) - (e.derrotas * 3)), " +
            "SUM(e.vitorias), " +
            "SUM(e.kills)) " +
            "FROM EstatisticasModel e " +
            "JOIN e.usuariosModel u " +
            "WHERE e.stsProvacao = 1 " + // Apenas estatísticas validadas
            "GROUP BY u.id, u.nickname " +
            "ORDER BY 2 DESC") // Ordena pela pontuação (2º parametro do construtor)
    Page<RankingDTO> buscarRankingGlobal(Pageable pageable);
}
package com.doback.E_rank.infrastructure.repository.jpa;

import com.doback.E_rank.dto.EstatisticasConsolidadasDTO; // Import Adicionado
import com.doback.E_rank.dto.RankingDTO;
import com.doback.E_rank.infrastructure.models.EstatisticasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Import Adicionado

import java.util.List;

public interface EstatisticasJpa extends JpaRepository<EstatisticasModel, Integer> {

    List<EstatisticasModel> findByJogosModelIdAndStsProvacao(int jogoId, int stsProvacao);
    List<EstatisticasModel> findByUsuariosModelIdAndStsProvacao(int usuarioId, int stsProvacao);

    boolean existsByDesafiosModelIdAndUsuariosModelId(int desafioId, int usuarioId);
    long countByDesafiosModelId(int desafioId);

    List<EstatisticasModel> findByDesafiosModelId(int desafioId);

    // --- QUERY RANKING GLOBAL ---
    @Query("SELECT new com.doback.E_rank.dto.RankingDTO(" +
            "u.nickname, " +
            "SUM(CASE WHEN e.resultadoVitoria = true THEN 10 ELSE -3 END + (e.kills * 2)), " +
            "SUM(CASE WHEN e.resultadoVitoria = true THEN 1 ELSE 0 END), " +
            "SUM(e.kills)) " +
            "FROM EstatisticasModel e " +
            "JOIN e.usuariosModel u " +
            "WHERE e.stsProvacao = 1 " +
            "GROUP BY u.id, u.nickname " +
            "ORDER BY 2 DESC")
    Page<RankingDTO> buscarRankingGlobal(Pageable pageable);

    // --- QUERY ESTATÍSTICAS CONSOLIDADAS ---
    @Query("SELECT new com.doback.E_rank.dto.EstatisticasConsolidadasDTO(" +
            "u.nickname, " +
            "COUNT(e), " +
            "COALESCE(SUM(CASE WHEN e.resultadoVitoria = true THEN 1 ELSE 0 END), 0), " +
            "COALESCE(SUM(CASE WHEN e.resultadoVitoria = false THEN 1 ELSE 0 END), 0), " +
            "COALESCE(SUM(e.kills), 0), " +
            "COALESCE(SUM(e.assistencias), 0), " +
            "COALESCE(SUM(e.headshots), 0)) " +
            "FROM EstatisticasModel e " +
            "JOIN e.usuariosModel u " +
            "WHERE u.id = :usuarioId")
    EstatisticasConsolidadasDTO buscarConsolidadoPorUsuario(@Param("usuarioId") int usuarioId);
}
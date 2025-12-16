package com.doback.E_rank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstatisticasConsolidadasDTO {
    private String nickname;
    private long totalPartidas;
    private long vitorias;
    private long derrotas;
    private long totalKills;
    private long totalAssistencias;
    private long totalHeadshots;


    public double getKdRatio() {
        long base = derrotas > 0 ? derrotas : 1;
        return (double) totalKills / base;
    }
}
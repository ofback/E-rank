package com.doback.E_rank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComparacaoDTO {
    private String nickname;
    private String nome;
    private long totalPartidas;
    private long totalVitorias;
    private long totalDerrotas;
    private long totalKills;
    private long totalAssistencias;
    private double kdRatio;

    public ComparacaoDTO(String nickname, String nome) {
        this.nickname = nickname;
        this.nome = nome;
    }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public long getTotalPartidas() { return totalPartidas; }
    public void setTotalPartidas(long totalPartidas) { this.totalPartidas = totalPartidas; }
    public long getTotalVitorias() { return totalVitorias; }
    public void setTotalVitorias(long totalVitorias) { this.totalVitorias = totalVitorias; }
    public long getTotalDerrotas() { return totalDerrotas; }
    public void setTotalDerrotas(long totalDerrotas) { this.totalDerrotas = totalDerrotas; }
    public long getTotalKills() { return totalKills; }
    public void setTotalKills(long totalKills) { this.totalKills = totalKills; }
    public long getTotalAssistencias() { return totalAssistencias; }
    public void setTotalAssistencias(long totalAssistencias) { this.totalAssistencias = totalAssistencias; }
    public double getKdRatio() { return kdRatio; }
    public void setKdRatio(double kdRatio) { this.kdRatio = kdRatio; }
}

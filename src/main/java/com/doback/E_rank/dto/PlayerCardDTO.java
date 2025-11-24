package com.doback.E_rank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCardDTO {
    private String nickname;
    private String nome;
    private int overallRating;
    private String estiloDeJogo;

    // Estatísticas da Carta
    private long vitorias;
    private long derrotas;
    private long kills;
    private long assistencias;
    private long headshots;
    private long recordKills; // Campo novo (RCK)

    // Dados extras
    private double kdRatio;
    private long partidasJogadas;

    // Construtor manual de conveniência (opcional, mas útil se o RankingApplication usar)
    public PlayerCardDTO(String nickname, String nome) {
        this.nickname = nickname;
        this.nome = nome;
    }
}
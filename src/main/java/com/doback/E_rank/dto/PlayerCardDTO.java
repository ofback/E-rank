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


    private long vitorias;
    private long derrotas;
    private long kills;
    private long assistencias;
    private long headshots;
    private long recordKills;


    private double kdRatio;
    private long partidasJogadas;

    public PlayerCardDTO(String nickname, String nome) {
        this.nickname = nickname;
        this.nome = nome;
    }
}
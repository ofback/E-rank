// E-rank/src/main/java/com/doback/E_rank/dto/CreateEstatisticaDTO.java
package com.doback.E_rank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEstatisticaDTO {
    private int desafioId;   // Qual desafio foi jogado?
    private boolean vitoria; // Ganhei? (true/false)
    private int pontos;      // Placar ou pontuação geral

    // Dados específicos (Kills, Assistências) em formato flexível ou campos opcionais
    private int kills;
    private int deaths;
    private int assistencias;
    private int headshots;
}
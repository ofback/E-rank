// E-rank/src/main/java/com/doback/E_rank/dto/CreateEstatisticaDTO.java
package com.doback.E_rank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEstatisticaDTO {
    private int desafioId;
    private boolean vitoria;
    private int pontos;


    private int kills;
    private int deaths;
    private int assistencias;
    private int headshots;
}
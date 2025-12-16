// E-rank/src/main/java/com/doback/E_rank/dto/DesafioResponseDTO.java
package com.doback.E_rank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DesafioResponseDTO {
    private int id;
    private String desafianteNome;
    private String status;
    private String dataHora;
}
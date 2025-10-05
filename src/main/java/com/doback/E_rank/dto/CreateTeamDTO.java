package com.doback.E_rank.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CreateTeamDTO {
    private String nome;
    private String descricao;
    private List<Integer> memberIds; // Lista de IDs dos amigos a serem convidados
}

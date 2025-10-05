package com.doback.E_rank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendRequestDTO {
    // O frontend só precisa enviar o ID do usuário que será adicionado.
    private int idUsuario2;
}
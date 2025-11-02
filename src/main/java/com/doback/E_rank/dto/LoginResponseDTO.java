package com.doback.E_rank.dto;

import com.doback.E_rank.infrastructure.models.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private UsuariosModel usuario; // O seu auth_service.dart espera por um objeto 'usuario'
}
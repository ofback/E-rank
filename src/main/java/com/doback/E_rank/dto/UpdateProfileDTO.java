package com.doback.E_rank.dto;

// Usaremos anotações do Lombok para reduzir o código boilerplate (getters/setters)
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileDTO {
    private String nickname;
    private String biografia;
}
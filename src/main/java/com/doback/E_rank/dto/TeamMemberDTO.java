package com.doback.E_rank.dto;

public class TeamMemberDTO {
    private int userId;
    private String nickname;
    private String cargo;
    private String dataEntrada;
    private String status; // Novo campo: 'A' (Ativo) ou 'P' (Pendente)

    public TeamMemberDTO(int userId, String nickname, String cargo, String dataEntrada, String status) {
        this.userId = userId;
        this.nickname = nickname;
        this.cargo = cargo;
        this.dataEntrada = dataEntrada;
        this.status = status;
    }

    public TeamMemberDTO() {}

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(String dataEntrada) { this.dataEntrada = dataEntrada; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
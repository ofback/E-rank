package com.doback.E_rank.dto;

public class TeamMemberDTO {
    private int userId;
    private String nickname;
    private String cargo; // Dono, ViceLider, Membro
    private String dataEntrada;

    public TeamMemberDTO(int userId, String nickname, String cargo, String dataEntrada) {
        this.userId = userId;
        this.nickname = nickname;
        this.cargo = cargo;
        this.dataEntrada = dataEntrada;
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
}
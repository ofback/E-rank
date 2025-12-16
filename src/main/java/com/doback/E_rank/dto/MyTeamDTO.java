package com.doback.E_rank.dto;

public class MyTeamDTO {
    private int id;
    private String nome;
    private String cargo;
    private String status;

    public MyTeamDTO(int id, String nome, String cargo, String status) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
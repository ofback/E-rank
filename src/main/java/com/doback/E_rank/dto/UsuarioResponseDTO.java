package com.doback.E_rank.dto;

import java.util.Date;

public class UsuarioResponseDTO {
    private int id;
    private String nome;
    private String nickname;
    private String email;
    private String biografia;
    private Date dataCriacao;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(int id, String nome, String nickname, String email, String biografia, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.biografia = biografia;
        this.dataCriacao = dataCriacao;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getBiografia() {
        return biografia;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
package com.doback.E_rank.dto;

public class CreateUsuarioDTO {

    private String nome;
    private String nickname;
    private String email;
    private String senha;
    private String cpf;
    private String dataNascimento;


    public CreateUsuarioDTO() {
    }


    public CreateUsuarioDTO(String nome, String nickname, String email, String senha, String cpf, String dataNascimento) {
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
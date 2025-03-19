package com.doback.E_rank.entity;

public class Times {
    private Long idTimes;
    private String nome;
    private String descricao;
    private Long status;

    public Times(Long idTimes, String nome, String descricao, Long status) {
        this.idTimes = idTimes;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public Long getIdTimes() {
        return idTimes;
    }

    public void setIdTimes(Long idTimes) {
        this.idTimes = idTimes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

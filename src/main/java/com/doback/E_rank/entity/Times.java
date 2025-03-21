package com.doback.E_rank.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "times")
public class Times {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times")
    private Long times;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private Long status;

    public Times(Long idTimes, String nome, String descricao, Long status) {
        this.times = idTimes;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
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

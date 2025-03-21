package com.doback.E_rank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jogos")

public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idJogo")
    private Long idJogo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "genero")
    private String genero;

    public Jogos(Long idJogo, String nome, String descricao, String genero) {
        this.idJogo = idJogo;
        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero;
    }

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

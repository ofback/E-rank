package com.doback.E_rank.entity;

public class Temporadas {
    private Long idTemporada;
    private String nome;
    private String descricao;


    public Temporadas(Long idTemporada, String nome, String descricao) {
        this.idTemporada = idTemporada;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static Temporadas stream() {
        return null;
    }

    public static void removeIf(Object o) {
    }

    public Long getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Long idTemporada) {
        this.idTemporada = idTemporada;
    }

    private Long IdTemporada() {
        return 0L;
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

    public void add(Temporadas temporada) {
    }
}

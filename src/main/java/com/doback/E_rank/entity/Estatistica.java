package com.doback.E_rank.entity;

public class Estatistica {
    private Long id;
    private Long usuarioId;
    private int pontos;
    private int vitorias;
    private int derrotas;

    public Estatistica(Long id, Long usuarioId, int pontos, int vitorias, int derrotas) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.pontos = pontos;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
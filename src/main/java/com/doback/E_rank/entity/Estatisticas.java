package com.doback.E_rank.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="estatísticas")

public class Estatisticas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_estatistica")
    private Long id_estatistica;
    @Column(name = "kilss")
    private Long kills;
    @Column(name = "assistencias")
    private int assistencias;
    @Column(name = "qts_partidas")
    private int qts_partidas;
    @Column(name = "sts_provacao")
    private int sts_provacao;
    @Column(name = "vitorias")
    private int vitorias;
    @Column(name = "derrotas")
    private int derrotas;
    @Column(name = "recordKills")
    private int recordKills;
    @Column(name = "headshots")
    private int headshots;

    public Estatisticas(Long id_estatistica, Long kills, int assistencias, int qts_partidas, int sts_provacao, int vitorias, int derrotas, int recordKills, int headshots) {
        this.id_estatistica = id_estatistica;
        this.kills = kills;
        this.assistencias = assistencias;
        this.qts_partidas = qts_partidas;
        this.sts_provacao = sts_provacao;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.recordKills = recordKills;
        this.headshots = headshots;
    }

    public Estatisticas() {

    }


    public Long getId_estatistica() {
        return id_estatistica;
    }

    public void setId_estatistica(Long id_estatistica) {
        this.id_estatistica = id_estatistica;
    }

    public Long getKills() {
        return kills;
    }

    public void setKills(Long kills) {
        this.kills = kills;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getQts_partidas() {
        return qts_partidas;
    }

    public void setQts_partidas(int qts_partidas) {
        this.qts_partidas = qts_partidas;
    }

    public int getSts_provacao() {
        return sts_provacao;
    }

    public void setSts_provacao(int sts_provacao) {
        this.sts_provacao = sts_provacao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getRecordKills() {
        return recordKills;
    }

    public void setRecordKills(int recordKills) {
        this.recordKills = recordKills;
    }

    public int getHeadshots() {
        return headshots;
    }

    public void setHeadshots(int headshots) {
        this.headshots = headshots;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
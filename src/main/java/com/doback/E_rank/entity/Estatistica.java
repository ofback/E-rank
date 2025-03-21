package com.doback.E_rank.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="estatísticas")

public class Estatistica {
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

    public Estatistica(Long id_estatistica, Long kills, int assistencias, int qts_partidas, int sts_provacao) {
        this.id_estatistica = id_estatistica;
        this.kills = kills;
        this.assistencias = assistencias;
        this.qts_partidas = qts_partidas;
        this.sts_provacao = sts_provacao;
    }

    public Estatistica() {

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
}
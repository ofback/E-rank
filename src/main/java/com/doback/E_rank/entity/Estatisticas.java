package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estatisticas")
public class Estatisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kills")
    private Long kills;

    @Column(name = "assistencias")
    private int assistencias;

    @Column(name = "qts_partidas")
    private int qtsPartidas;

    @Column(name = "sts_provacao")
    private int stsProvacao;

    @Column(name = "vitorias")
    private int vitorias;

    @Column(name = "derrotas")
    private int derrotas;

    @Column(name = "recordKills")
    private int recordKills;

    @Column(name = "headshots")
    private int headshots;

    @OneToMany(mappedBy = "estatisticas", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticas> votacaoEstatisticas = new ArrayList<>();


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuario;

    @Column(name = "id_usuario")
    private int idUsuario;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id", insertable = false, updatable = false)
    private Jogos jogos;

    @Column(name = "id_jogo")
    private int idJogo;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_desafio", referencedColumnName = "id", insertable = false, updatable = false)
    private Desafios desafio;

    @Column(name = "id_desafio")
    private int idDesafio;

    public Estatisticas( Long kills, int assistencias, int qtsPartidas, int stsProvacao, int vitorias, int derrotas, int recordKills, int headshots, Jogos jogos, Desafios desafio, Usuarios usuario) {
        this.kills = kills;
        this.assistencias = assistencias;
        this.qtsPartidas = qtsPartidas;
        this.stsProvacao = stsProvacao;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.recordKills = recordKills;
        this.headshots = headshots;
        this.jogos = jogos;
        this.usuario = usuario;
        this.desafio = desafio;
    }

    public Estatisticas() {
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

    public int getQtsPartidas() {
        return qtsPartidas;
    }

    public void setQtsPartidas(int qtsPartidas) {
        this.qtsPartidas = qtsPartidas;
    }

    public int getStsProvacao() {
        return stsProvacao;
    }

    public void setStsProvacao(int stsProvacao) {
        this.stsProvacao = stsProvacao;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }
}

package com.doback.E_rank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estatisticas")
public class Estatisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estatistica")
    private Long idEstatistica;

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


    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_jogo", referencedColumnName = "id_jogo")
    private Jogos jogos;

    @ManyToOne
    @JoinColumn(name = "desafio_id", referencedColumnName = "id_desafio")
    private Desafios desafio;

    public Estatisticas(Long idEstatistica, Long kills, int assistencias, int qtsPartidas, int stsProvacao, int vitorias, int derrotas, int recordKills, int headshots) {
        this.idEstatistica = idEstatistica;
        this.kills = kills;
        this.assistencias = assistencias;
        this.qtsPartidas = qtsPartidas;
        this.stsProvacao = stsProvacao;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.recordKills = recordKills;
        this.headshots = headshots;
    }

    public Estatisticas() {
    }


    public Long getIdEstatistica() {
        return idEstatistica;
    }

    public void setIdEstatistica(Long idEstatistica) {
        this.idEstatistica = idEstatistica;
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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }

    public Desafios getDesafio() {
        return desafio;
    }

    public void setDesafio(Desafios desafio) {
        this.desafio = desafio;
    }
}

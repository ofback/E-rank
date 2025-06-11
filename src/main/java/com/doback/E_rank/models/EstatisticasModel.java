package com.doback.E_rank.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estatisticas")
public class EstatisticasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kills")
    private int kills;

    @Column(name = "assistencias")
    private int assistencias;

    @Column(name = "qts_partidas")
    private int qtdPartidas;

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

    @OneToMany(mappedBy = "estatisticasModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticasModel> votacaoEstatisticaModels = new ArrayList<>();


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel;

    @Column(name = "id_usuario")
    private int idUsuario;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id", insertable = false, updatable = false)
    private JogosModel jogosModel;

    @Column(name = "id_jogo")
    private int idJogo;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_desafio", referencedColumnName = "id", insertable = false, updatable = false)
    private DesafiosModel desafiosModel;

    @Column(name = "id_desafio")
    private int idDesafio;

    public EstatisticasModel(int kills, int assistencias, int qtdPartidas, int stsProvacao, int vitorias, int derrotas, int recordKills, int headshots, JogosModel jogosModel, DesafiosModel desafiosModel, UsuariosModel usuariosModel) {
        this.kills = kills;
        this.assistencias = assistencias;
        this.qtdPartidas = qtdPartidas;
        this.stsProvacao = stsProvacao;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.recordKills = recordKills;
        this.headshots = headshots;
        this.jogosModel = jogosModel;
        this.usuariosModel = usuariosModel;
        this.desafiosModel = desafiosModel;
    }

    public EstatisticasModel() {
    }


    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getQtdPartidas() {
        return qtdPartidas;
    }

    public void setQtdPartidas(int qtdPartidas) {
        this.qtdPartidas = qtdPartidas;
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


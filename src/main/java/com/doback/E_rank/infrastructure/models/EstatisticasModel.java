package com.doback.E_rank.infrastructure.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "estatisticas")
public class EstatisticasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "vitoria_booleana")
    private boolean resultadoVitoria;

    @Column(name = "pontos_partida")
    private Integer pontos;

    @Column(name = "kills")
    private Integer kills;

    @Column(name = "assistencias")
    private Integer assistencias;

    @Column(name = "headshots")
    private Integer headshots;

    @Column(name = "qts_partidas")
    private Integer qtdPartidas;

    @Column(name = "sts_provacao")
    private Integer stsProvacao;

    @Column(name = "vitorias")
    private Integer vitorias;

    @Column(name = "derrotas")
    private Integer derrotas;

    @Column(name = "recordKills")
    private Integer recordKills;


    @OneToMany(mappedBy = "estatisticasModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticasModel> votacaoEstatisticaModels = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuariosModel usuariosModel;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id")
    private JogosModel jogosModel;

    @OneToOne
    @JoinColumn(name = "id_desafio")
    private DesafiosModel desafiosModel;


    public int getPontos() {
        return pontos != null ? pontos : 0;
    }

    public int getKills() {
        return kills != null ? kills : 0;
    }

    public int getAssistencias() {
        return assistencias != null ? assistencias : 0;
    }

    public int getHeadshots() {
        return headshots != null ? headshots : 0;
    }

    public int getQtdPartidas() {
        return qtdPartidas != null ? qtdPartidas : 0;
    }

    public int getStsProvacao() {
        return stsProvacao != null ? stsProvacao : 0;
    }

    public int getVitorias() {
        return vitorias != null ? vitorias : 0;
    }

    public int getDerrotas() {
        return derrotas != null ? derrotas : 0;
    }

    public int getRecordKills() {
        return recordKills != null ? recordKills : 0;
    }
}
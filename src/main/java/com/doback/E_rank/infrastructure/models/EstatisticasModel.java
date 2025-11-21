// E-rank/src/main/java/com/doback/E_rank/infrastructure/models/EstatisticasModel.java
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

    // --- Campos da Partida (RF09) ---

    @Column(name = "vitoria_booleana")
    private boolean resultadoVitoria; // true = vitoria, false = derrota

    @Column(name = "pontos_partida")
    private int pontos; // Pontuação desta partida específica

    // --- Campos Específicos (FPS/Geral) ---
    @Column(name = "kills")
    private int kills;

    @Column(name = "assistencias")
    private int assistencias;

    @Column(name = "headshots")
    private int headshots;

    // Estes campos abaixo parecem ser de "Acumulado", 
    // mas vamos mantê-los para não quebrar seu banco, 
    // embora para uma partida única eles não façam tanto sentido.
    @Column(name = "qts_partidas")
    private int qtdPartidas;

    @Column(name = "sts_provacao")
    private int stsProvacao;

    @Column(name = "vitorias")
    private int vitorias; // Contador acumulado?

    @Column(name = "derrotas")
    private int derrotas; // Contador acumulado?

    @Column(name = "recordKills")
    private int recordKills;

    // --- RELACIONAMENTOS ---

    @OneToMany(mappedBy = "estatisticasModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticasModel> votacaoEstatisticaModels = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private UsuariosModel usuariosModel;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id")
    private JogosModel jogosModel;

    // --- NOVO RELACIONAMENTO (CRÍTICO PARA RF09) ---
    // Vincula esta estatística ao desafio que a originou
    @OneToOne
    @JoinColumn(name = "id_desafio")
    private DesafiosModel desafiosModel;
}
package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "votacaoEstatisticas")
public class VotacaoEstatisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_votacao_estatisticas")
    private Long id_votacao_estatistica;

    @Column(name = "voto")
    private boolean voto;

    @Column(name = "data_voto")
    private Date data_voto;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estatistica")
    private Estatisticas estatisticas;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_temporada")
    private Temporadas temporadas;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo")
    private Jogos jogos;

    public VotacaoEstatisticas(Long id_votacao_estatistica, boolean voto, Date data_voto) {
        this.id_votacao_estatistica = id_votacao_estatistica;
        this.voto = voto;
        this.data_voto = data_voto;
    }

    public VotacaoEstatisticas() {
    }

    public Long getId_votacao_estatistica() {
        return id_votacao_estatistica;
    }

    public void setId_votacao_estatistica(Long id_votacao_estatistica) {
        this.id_votacao_estatistica = id_votacao_estatistica;
    }

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    public Date getData_voto() {
        return data_voto;
    }

    public void setData_voto(Date data_voto) {
        this.data_voto = data_voto;
    }

//    public Estatisticas getEstatisticas() {
//        return estatisticas;
//    }
//
//    public void setEstatisticas(Estatisticas estatisticas) {
//        this.estatisticas = estatisticas;
//    }
//
//    public Usuarios getUsuarios() {
//        return usuarios;
//    }
//
//    public void setUsuarios(Usuarios usuarios) {
//        this.usuarios = usuarios;
//    }
//
//    public Temporadas getTemporadas() {
//        return temporadas;
//    }
//
//    public void setTemporadas(Temporadas temporadas) {
//        this.temporadas = temporadas;
//    }
//
//    public Jogos getJogos() {
//        return jogos;
//    }
//
//    public void setJogos(Jogos jogos) {
//        this.jogos = jogos;
//    }

}

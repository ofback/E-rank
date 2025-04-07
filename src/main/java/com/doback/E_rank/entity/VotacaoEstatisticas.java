package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "votacaoEstatisticas")
public class VotacaoEstatisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "voto")
    private boolean voto;

    @Column(name = "data_voto")
    private Date data_voto;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estatistica")
    private Estatisticas estatisticas;

    @Column(name = "id_estatistica")
    private int idEstatistica;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuario;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_temporada", referencedColumnName = "id", insertable = false, updatable = false)
    private Temporadas temporadas;

    @Column(name = "id_temporada")
    private int idTemporada;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id", insertable = false, updatable = false)
    private Jogos jogos;

    @Column(name = "id_jogo")
    private int idJogo;

    public VotacaoEstatisticas(boolean voto, Date data_voto, Estatisticas estatisticas, Usuarios usuario, Temporadas temporadas, Jogos jogos) {
        this.voto = voto;
        this.data_voto = data_voto;
        this.estatisticas = estatisticas;
        this.usuario = usuario;
        this.temporadas = temporadas;
        this.jogos = jogos;
    }

    public VotacaoEstatisticas() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

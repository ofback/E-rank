package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "votacaoEstatisticas")
public class VotacaoEstatisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "voto")
    private boolean voto;

    @Column(name = "data_voto")
    private Date data_voto;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estatistica", referencedColumnName = "id", insertable = false, updatable = false)
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

    public VotacaoEstatisticas(boolean voto, Date data_voto, Estatisticas estatisticas, Usuarios usuario, Temporadas temporadas) {
        this.voto = voto;
        this.data_voto = data_voto;
        this.estatisticas = estatisticas;
        this.usuario = usuario;
        this.temporadas = temporadas;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdEstatistica() {
        return idEstatistica;
    }

    public void setIdEstatistica(int idEstatistica) {
        this.idEstatistica = idEstatistica;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }
}

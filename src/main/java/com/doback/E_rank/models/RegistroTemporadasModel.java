package com.doback.E_rank.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "registroTemporadas")
public class RegistroTemporadasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private String data;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_temporada", referencedColumnName = "id", insertable = false, updatable = false)
    private TemporadasModel temporadasModel;

    @Column(name = "id_temporada")
    private int idTemporada;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_time", referencedColumnName = "id", insertable = false, updatable = false)
    private TimesModel timesModel;

    @Column(name = "id_time")
    private int idTime;


    public RegistroTemporadasModel(TemporadasModel temporadasModel, TimesModel timesModel, String data) {
        this.temporadasModel = temporadasModel;
        this.timesModel = timesModel;
        this.data = data;
    }

    public RegistroTemporadasModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


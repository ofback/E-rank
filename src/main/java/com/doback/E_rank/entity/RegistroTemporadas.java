package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "registroTemporadas")
public class RegistroTemporadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private Date data;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_temporada", referencedColumnName = "id", insertable = false, updatable = false)
    private Temporadas temporada;

    @Column(name = "id_temporada")
    private int idTemporada;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_time", referencedColumnName = "id", insertable = false, updatable = false)
    private Times time;

    @Column(name = "id_time")
    private int idTime;


    public RegistroTemporadas( Temporadas temporada, Times time, Date data) {
        this.temporada = temporada;
        this.time = time;
        this.data = data;
    }

    public RegistroTemporadas() {

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

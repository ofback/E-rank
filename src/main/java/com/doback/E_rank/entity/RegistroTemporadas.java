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


//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_temporada", referencedColumnName = "id", insertable = false, updatable = false)
//    private Temporadas temporada;

    @Column(name = "id_temporada")
    private Long idTemporada;


//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_time", referencedColumnName = "id", insertable = false, updatable = false)
//    private Times time;

    @Column(name = "id_time")
    private Long idTime;


    public RegistroTemporadas(/* Temporadas temporada, Times time, */Date data) {
//        this.temporada = temporada;
//        this.time = time;
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


//    public Temporadas getTemporada() {
//        return temporada;
//    }
//
//    public void setTemporada(Temporadas temporada) {
//        this.temporada = temporada;
//    }
//
//    public Times getTime() {
//        return time;
//    }
//
//    public void setTime(Times time) {
//        this.time = time;
//    }
}

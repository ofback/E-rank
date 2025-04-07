package com.doback.E_rank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registroTemporadas")
public class RegistroTemporadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Temporadas temporada;

    @Column(name = "id")
    private long idTemporada;


    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Times time;

    @Column(name = "id")
    private long idTime;


    public RegistroTemporadas( Temporadas temporada, Times time) {
        this.temporada = temporada;
        this.time = time;
    }

    public RegistroTemporadas() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

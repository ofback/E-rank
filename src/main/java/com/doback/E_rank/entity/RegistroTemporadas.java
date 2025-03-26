package com.doback.E_rank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registroTemporadas")
public class RegistroTemporadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_temporadas")
    private long id_registro_temporadas;

    @ManyToOne
    @JoinColumn(name = "id_temporada", referencedColumnName = "id_temporada")
    private Temporadas temporada;

    @ManyToOne
    @JoinColumn(name = "id_time", referencedColumnName = "id_time")
    private Times time;

    public RegistroTemporadas(long id_registro_temporadas, Temporadas temporada, Times time) {
        this.id_registro_temporadas = id_registro_temporadas;
        this.temporada = temporada;
        this.time = time;
    }

    public RegistroTemporadas() {

    }

    public long getId_registro_temporadas() {
        return id_registro_temporadas;
    }

    public void setId_registro_temporadas(long id_registro_temporadas) {
        this.id_registro_temporadas = id_registro_temporadas;
    }

    public Temporadas getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporadas temporada) {
        this.temporada = temporada;
    }

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }
}

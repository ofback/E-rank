package com.doback.E_rank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Registro_temporadas")
public class RegistroTemporadas {

    @Id
    @Column(name = "id_registro_temporadas")
    private long id_registro_temporadas;

    public RegistroTemporadas(long id_registro_temporadas) {
        this.id_registro_temporadas = id_registro_temporadas;
    }

    public long getId_registro_temporadas() {
        return id_registro_temporadas;
    }

    public void setId_registro_temporadas(long id_registro_temporadas) {
        this.id_registro_temporadas = id_registro_temporadas;
    }
}

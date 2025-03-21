package com.doback.E_rank.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="desafios")

public class Desafios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idDesafio")
    private Long idDesafio;
    @Column(name = "idUsuario1")
    private Long idUsuario1;
    @Column(name = "idUsuario2")
    private Long idUsuario2;
    @Column(name = "status")
    private Long status;

    public Desafios(Long idDesafio, Long idUsuario1, Long idUsuario2, Long status) {
        this.idDesafio = idDesafio;
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
        this.status = status;
    }

    public Desafios() {

    }

    public Long getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(Long idDesafio) {
        this.idDesafio = idDesafio;
    }

    public Long getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Long idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Long getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Long idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

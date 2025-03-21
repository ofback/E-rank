package com.doback.E_rank.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "amizades")
public class Amizades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amizades")
    private Long amizades;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times")
    private Long usuario1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "times")
    private Long usuario2;

    @Column(name = "status")
    private Long status;


    public Amizades(Long idAmizade, Long idUsuario1, Long idUsuario2, Long status) {
        amizades = idAmizade;
        usuario1 = idUsuario1;
        usuario2 = idUsuario2;
        this.status = status;
    }

    public Long getAmizades() {
        return amizades;
    }

    public void setAmizades(Long amizades) {
        this.amizades = amizades;
    }

    public Long getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Long usuario1) {
        this.usuario1 = usuario1;
    }

    public Long getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Long usuario2) {
        this.usuario2 = usuario2;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "amizades")
public class Amizades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_amizade")
    private Long id_amizade;


    @Column(name = "id_usuario1")
    private Long id_usuario1;


    @Column(name = "id_usuario2")
    private Long id_usuario2;

    @Column(name = "sts")
    private char sts;

    @Column(name = "data_solicitacao")
    private Date data_solicitacao;


    public Amizades(Long id_amizade, Long id_usuario1, Long id_usuario2, char sts, Date data_solicitacao) {
        this.id_amizade = id_amizade;
        this.id_usuario1 = id_usuario1;
        this.id_usuario2 = id_usuario2;
        this.sts = sts;
        this.data_solicitacao = data_solicitacao;
    }

    public Long getId_amizade() {
        return id_amizade;
    }

    public void setId_amizade(Long id_amizade) {
        this.id_amizade = id_amizade;
    }

    public Long getId_usuario1() {
        return id_usuario1;
    }

    public void setId_usuario1(Long id_usuario1) {
        this.id_usuario1 = id_usuario1;
    }

    public Long getId_usuario2() {
        return id_usuario2;
    }

    public void setId_usuario2(Long id_usuario2) {
        this.id_usuario2 = id_usuario2;
    }

    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }

    public Date getData_solicitacao() {return data_solicitacao;
    }

    public void setData_solicitacao(Date data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }
}

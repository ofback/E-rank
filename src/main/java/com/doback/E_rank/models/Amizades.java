package com.doback.E_rank.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "amizades")
public class Amizades {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sts")
    private char sts;

    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;

    @OneToMany(mappedBy = "amizade", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Desafios> desafios = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuario1;

    @Column(name = "id_usuario1")
    private int idUsuario1;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuario2;

    @Column(name = "id_usuario2")
    private int idUsuario2;

    public Amizades() {

    }

    public Amizades( Usuarios usuario1, Usuarios usuario2, char sts, Date dataSolicitacao) {

        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.sts = sts;
        this.dataSolicitacao = dataSolicitacao;
    }

    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(int idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public int getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(int idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }
}

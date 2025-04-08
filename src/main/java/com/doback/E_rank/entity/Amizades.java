package com.doback.E_rank.entity;

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
    private Long id;


//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_usuario1", referencedColumnName = "id", insertable = false, updatable = false)
//    private Usuarios usuario1;

    @Column(name = "id_usuario1")
    private Long idUsuario1;

//    @OneToMany(mappedBy = "amizade", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private List<Desafios> desafios = new ArrayList<>();

//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_usuario2", referencedColumnName = "id", insertable = false, updatable = false)
//    private Usuarios usuario2;

    @Column(name = "id_usuario2")
    private Long idUsuario2;

    @Column(name = "sts")
    private char sts;

    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;

    public Amizades( /*Usuarios usuario1, Usuarios usuario2,*/ char sts, Date dataSolicitacao) {

//        this.usuario1 = usuario1;
//        this.usuario2 = usuario2;
        this.sts = sts;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Amizades() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Usuarios getUsuario1() {
//        return usuario1;
//    }
//
//    public void setUsuario1(Usuarios usuario1) {
//        this.usuario1 = usuario1;
//    }
//
//    public Usuarios getUsuario2() {
//        return usuario2;
//    }
//
//    public void setUsuario2(Usuarios usuario2) {
//        this.usuario2 = usuario2;
//    }
}

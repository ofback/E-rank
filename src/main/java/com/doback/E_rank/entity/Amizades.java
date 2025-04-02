package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "amizades")
public class Amizades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_amizade")
    private Long idAmizade;

    @Column(name = "sts")
    private char sts;

    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario1", referencedColumnName = "id_usuario")
    private Usuarios usuario1;

    @ManyToOne
    @JoinColumn(name = "id_usuario2", referencedColumnName = "id_usuario")
    private Usuarios usuario2;

    public Amizades(Long idAmizade, Usuarios usuario1, Usuarios usuario2, char sts, Date dataSolicitacao) {
        this.idAmizade = idAmizade;
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.sts = sts;
        this.dataSolicitacao = dataSolicitacao;
    }

    public Amizades() {
    }

    public Long getIdAmizade() {
        return idAmizade;
    }

    public void setIdAmizade(Long idAmizade) {
        this.idAmizade = idAmizade;
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

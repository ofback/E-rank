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

    public Amizades(Long idAmizade, Long idUsuario1, Long idUsuario2, char sts, Date dataSolicitacao) {
        this.idAmizade = idAmizade;
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
}

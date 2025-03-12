package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VotacaoEstatistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVotacao;

    @ManyToOne
    @JoinColumn(name = "id_estatistica", nullable = false)
    private Estatistica estatistica;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoVoto voto;

    private LocalDateTime dataVoto;


    public Long getIdVotacao() {
        return idVotacao;
    }

    public void setIdVotacao(Long idVotacao) {
        this.idVotacao = idVotacao;
    }

    public Estatistica getEstatistica() {
        return estatistica;
    }

    public void setEstatistica(Estatistica estatistica) {
        this.estatistica = estatistica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoVoto getVoto() {
        return voto;
    }

    public void setVoto(TipoVoto voto) {
        this.voto = voto;
    }

    public LocalDateTime getDataVoto() {
        return dataVoto;
    }

    public void setDataVoto(LocalDateTime dataVoto) {
        this.dataVoto = dataVoto;
    }
}

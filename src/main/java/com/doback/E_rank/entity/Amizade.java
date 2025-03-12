package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmizade;

    @ManyToOne
    @JoinColumn(name = "id_usuario_1")
    private Usuario usuario1;

    @ManyToOne
    @JoinColumn(name = "id_usuario_2")
    private Usuario usuario2;

    private String status; // Ex: "pendente", "aceito", "bloqueado"

    private LocalDateTime dataSolicitacao;


    public Long getIdAmizade() {
        return idAmizade;
    }

    public void setIdAmizade(Long idAmizade) {
        this.idAmizade = idAmizade;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    public Usuario getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario usuario2) {
        this.usuario2 = usuario2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
}

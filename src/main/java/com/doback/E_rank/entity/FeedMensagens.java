package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class FeedMensagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedMensagem;

    private String atividade;
    private String descricao;
    private String mensagem;
    private char statusEnvio; //'N' para não enviado e 'E' para enviado

    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // Getters e Setters
    public Long getIdFeedMensagem() {
        return idFeedMensagem;
    }

    public void setIdFeedMensagem(Long idFeedMensagem) {
        this.idFeedMensagem = idFeedMensagem;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public char getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(char statusEnvio) {
        this.statusEnvio = statusEnvio;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

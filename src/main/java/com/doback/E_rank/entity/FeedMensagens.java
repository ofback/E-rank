package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feed_mensagens")
public class FeedMensagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feed_mensagens")
    private Long idFeedMensagens;

    @Column(name = "atividade")
    private String atividade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "status")
    private char status;

    @Column(name = "data_envio")
    private Date dataEnvio;


    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuario;


    public FeedMensagens(Long idFeedMensagens, String atividade, String descricao, String mensagem, char status, Date dataEnvio) {
        this.idFeedMensagens = idFeedMensagens;
        this.atividade = atividade;
        this.descricao = descricao;
        this.mensagem = mensagem;
        this.status = status;
        this.dataEnvio = dataEnvio;
    }

    public FeedMensagens() {
    }


    public Long getIdFeedMensagens() {
        return idFeedMensagens;
    }

    public void setIdFeedMensagens(Long idFeedMensagens) {
        this.idFeedMensagens = idFeedMensagens;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

//    public Usuarios getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuarios usuario) {
//        this.usuario = usuario;
//    }

}

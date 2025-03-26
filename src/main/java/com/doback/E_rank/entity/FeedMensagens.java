package com.doback.E_rank.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedMensagens")
public class FeedMensagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feed_mensagens")
    private Long id_feed_mensagens;

    @Column(name = "atividade")
    private String atividade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "status")
    private char status;

    @Column(name = "data_envio")
    private Date data_envio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;

    public FeedMensagens(Long id_feed_mensagens, String atividade, String descricao, String mensagem, char status, Date data_envio) {
        this.id_feed_mensagens = id_feed_mensagens;
        this.atividade = atividade;
        this.descricao = descricao;
        this.mensagem = mensagem;
        this.status = status;
        this.data_envio = data_envio;
    }

    public FeedMensagens() {
    }

    public Long getId_feed_mensagens() {
        return id_feed_mensagens;
    }

    public void setId_feed_mensagens(Long id_feed_mensagens) {
        this.id_feed_mensagens = id_feed_mensagens;
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

    public Date getData_envio() {
        return data_envio;
    }

    public void setData_envio(Date data_envio) {
        this.data_envio = data_envio;
    }

}


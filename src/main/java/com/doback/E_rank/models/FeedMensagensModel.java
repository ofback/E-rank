package com.doback.E_rank.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feed_mensagens")
public class FeedMensagensModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "atividade")
    private String atividade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "status")
    private char status;

    @Column(name = "data_envio")
    private String dataEnvio;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel;

    @Column(name = "id_usuario")
    private int idUsuario;


    public FeedMensagensModel(String atividade, String descricao, String mensagem, char status, String dataEnvio, UsuariosModel usuariosModel) {
        this.atividade = atividade;
        this.descricao = descricao;
        this.mensagem = mensagem;
        this.status = status;
        this.dataEnvio = dataEnvio;
        this.usuariosModel = usuariosModel;
    }

    public FeedMensagensModel() {
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

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

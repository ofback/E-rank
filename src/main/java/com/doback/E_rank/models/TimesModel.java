package com.doback.E_rank.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "times")
public class TimesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "sts")
    private char sts;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuariosModel usuariosModel;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_temporadas", referencedColumnName = "id", insertable = false, updatable = false)
    private TemporadasModel temporadasModel;

    @Column(name = "id_temporadas")
    private int idTemporada;

    @OneToMany(mappedBy = "timesModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTimesModel> registroTimeModels = new ArrayList<>();

    @OneToMany(mappedBy = "timesModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTemporadasModel> registroTemporadaModels = new ArrayList<>();

    public TimesModel(String nome, String descricao, char sts, TemporadasModel temporadasModel, UsuariosModel usuariosModel) {
        this.nome = nome;
        this.descricao = descricao;
        this.sts = sts;
        this.usuariosModel = usuariosModel;
        this.temporadasModel = temporadasModel;
    }

    public TimesModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

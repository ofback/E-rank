package com.doback.E_rank.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "times")
public class Times {

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
    private Usuarios usuario;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_temporadas", referencedColumnName = "id", insertable = false, updatable = false)
    private Temporadas temporadas;

    @Column(name = "id_temporadas")
    private int idTemporada;

    @OneToMany(mappedBy = "times", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTimes> registroTimes = new ArrayList<>();

    @OneToMany(mappedBy = "time", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTemporadas> registroTemporadas = new ArrayList<>();

    public Times(String nome, String descricao, char sts, Temporadas temporadas, Usuarios usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.sts = sts;
        this.usuario = usuario;
        this.temporadas = temporadas;
    }

    public Times() {
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

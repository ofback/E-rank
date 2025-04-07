package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "times")
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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


    @OneToMany(mappedBy = "times", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTimes> registros = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_temporadas", referencedColumnName = "id")
    private Temporadas temporada;

    @Column(name = "id_temporadas")
    private int idTemporada;



    public Times(String nome, String descricao, char sts, Usuarios usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.sts = sts;
        this.usuario = usuario;
    }

    public Times() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    public Usuarios getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuarios usuario) {
//        this.usuario = usuario;
//    }
//
//    public List<RegistroTimes> getRegistros() {
//        return registros;
//    }
//
//    public void setRegistros(List<RegistroTimes> registros) {
//        this.registros = registros;
//    }
//
//    public Temporadas getTemporada() {
//        return temporada;
//    }
//
//    public void setTemporada(Temporadas temporada) {
//        this.temporada = temporada;
//    }
}

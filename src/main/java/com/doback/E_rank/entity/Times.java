package com.doback.E_rank.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "times")
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_time")
    private Long idTime;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "sts")
    private char sts;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuario;

    @OneToMany(mappedBy = "times", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTimes> registros = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_temporada", referencedColumnName = "id_temporada")
    private Temporadas temporada;  // Relacionamento com Temporadas

    public Times(Long idTime, String nome, String descricao, char sts, Usuarios usuario) {
        this.idTime = idTime;
        this.nome = nome;
        this.descricao = descricao;
        this.sts = sts;
        this.usuario = usuario;
    }

    public Times() {
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
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

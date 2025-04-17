package com.doback.E_rank.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "jogos")
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "jogos", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<UsuariosJogos> usuariosJogos = new ArrayList<>();

    @OneToMany(mappedBy = "jogos", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Desafios> desafios = new ArrayList<>();

    @OneToMany(mappedBy = "jogos", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Estatisticas> estatisticas = new ArrayList<>();

    public Jogos(String nome, String descricao, String genero) {
        this.nome = nome;
        this.descricao = descricao;
        this.genero = genero;
    }

    public Jogos() {}

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

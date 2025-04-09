package com.doback.E_rank.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "temporadas")
public class Temporadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date data_inicio;

    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date data_fim;

    @OneToMany(mappedBy = "temporadas", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<VotacaoEstatisticas> votacaoEstatisticas = new ArrayList<>();

    @OneToMany(mappedBy = "temporadas", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Times> times;

    @OneToMany(mappedBy = "temporada", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<RegistroTemporadas> registroTemporadas  = new ArrayList<>();

    public Temporadas(String nome, String descricao, Date data_inicio, Date data_fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public Temporadas() {
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

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

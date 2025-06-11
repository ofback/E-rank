package com.doback.E_rank.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "desafios")
public class DesafiosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data_desafio")
    private String dataDesafio;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "sts")
    private char sts;

    @OneToMany(mappedBy = "desafiosModel", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<EstatisticasModel> estatisticasModels = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_amizade", referencedColumnName = "id", insertable = false, updatable = false)
    private AmizadesModel amizadesModel;

    @Column(name = "id_amizade")
    private int idAmizade;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo", referencedColumnName = "id", insertable = false, updatable = false)
    private JogosModel jogosModel;

    @Column(name = "id_jogo")
    private int idJogo;

    public DesafiosModel(String dataDesafio, String resultado, char sts, AmizadesModel amizadesModel, JogosModel jogosModel) {
        this.dataDesafio = dataDesafio;
        this.resultado = resultado;
        this.sts = sts;
        this.amizadesModel = amizadesModel;
        this.jogosModel = jogosModel;
    }

    public DesafiosModel() {
    }


    public String getDataDesafio() {
        return dataDesafio;
    }

    public void setDataDesafio(String dataDesafio) {
        this.dataDesafio = dataDesafio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public char getSts() {
        return sts;
    }

    public void setSts(char sts) {
        this.sts = sts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAmizade() {
        return idAmizade;
    }

    public void setIdAmizade(int idAmizade) {
        this.idAmizade = idAmizade;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }
}


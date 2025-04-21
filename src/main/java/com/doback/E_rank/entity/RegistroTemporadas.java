package com.doback.E_rank.entity;


import java.time.LocalDate;
import java.util.Date;

public class RegistroTemporadas {
    private int id;

    private Date data;


    private int idTemporada;


    private int idTime;

    public RegistroTemporadas(Date data, int idTemporada, int idTime) {
        this.data = data;
        this.idTemporada = idTemporada;
        this.idTime = idTime;
    }

    public RegistroTemporadas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean validarRegistroTemporadas() {
        LocalDate hoje = LocalDate.now();
        return data != null &&
                idTemporada > 0 &&
                idTime > 0;
    }

    public String getErrosValidacao() {
        StringBuilder errosValidacao = new StringBuilder();

        if (data == null) {
            errosValidacao.append("A data não pode ser vazia.");
        }
        if (idTemporada < 0 ) {
            errosValidacao.append("O idTemporada deve ser válido.");
        }

        if (idTime < 0 ) {
            errosValidacao.append("O idTime deve ser válido.");
        }
        return errosValidacao.toString().trim();
        }


    }


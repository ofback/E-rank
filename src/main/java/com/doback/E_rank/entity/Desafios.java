package com.doback.E_rank.entity;

import com.doback.E_rank.models.AmizadesModel;
import com.doback.E_rank.models.EstatisticasModel;
import com.doback.E_rank.models.JogosModel;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Desafios {

    private int id;

    private String dataDesafio;

    private String resultado;

    private char sts;

    private int idAmizade;

    private int idJogo;

    public Desafios(String dataDesafio, String resultado, char sts, int idAmizade, int idJogo) {
        this.dataDesafio = dataDesafio;
        this.resultado = resultado;
        this.sts = sts;
        this.idAmizade =idAmizade;
        this.idJogo = idJogo;
    }

    public Desafios() {
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


    public boolean validarDesafio() {
        return dataDesafio != null && !dataDesafio.trim().isEmpty() &&
                resultado != null && !resultado.trim().isEmpty() &&
                (resultado == "Vitoria" || resultado == "Derrota") &&
                (sts == 'A' || sts == 'I') &&
                idAmizade > 0 &&
                idJogo > 0;
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        if (dataDesafio == null || dataDesafio.trim().isEmpty()) erros.append("Data do desafio não pode estar vazia. ");
        if (resultado == null || resultado.trim().isEmpty()) erros.append("Resultado não pode ser vazio. ");
        if (resultado != "Vitoria" && resultado != "Derrota") erros.append("Resultado deve ser 'Vitoria' ou 'Derrota'. ");
        if (sts != 'A' && sts != 'I') erros.append("Status deve ser 'A' (ativo) ou 'I' (inativo). ");
        if (idAmizade <= 0) erros.append("Id da amizade deve ser maior que zero. ");
        if (idJogo <= 0) erros.append("Id do jogo deve ser maior que zero. ");

        return erros.toString().trim();
    }
}

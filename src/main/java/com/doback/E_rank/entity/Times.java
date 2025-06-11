package com.doback.E_rank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.doback.E_rank.infrastructure.models.RegistroTimesModel;
import com.doback.E_rank.infrastructure.models.RegistroTemporadasModel;

public class Times {

    private int id;
    private String nome;
    private String descricao;
    private char sts;
    private int idUsuario;
    private int idTemporada;
    private List<RegistroTimesModel> registroTimeModels = new ArrayList<>();
    private List<RegistroTemporadasModel> registroTemporadaModels = new ArrayList<>();

    public Times(String nome, String descricao, char sts, int idTemporada, int idUsuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.sts = sts;
        this.idUsuario = idUsuario;
        this.idTemporada = idTemporada;
    }

    public Times() {}

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

    public List<RegistroTimesModel> getRegistroTimeModels() {
        return registroTimeModels;
    }

    public void setRegistroTimeModels(List<RegistroTimesModel> registroTimeModels) {
        this.registroTimeModels = registroTimeModels;
    }

    public List<RegistroTemporadasModel> getRegistroTemporadaModels() {
        return registroTemporadaModels;
    }

    public void setRegistroTemporadaModels(List<RegistroTemporadasModel> registroTemporadaModels) {
        this.registroTemporadaModels = registroTemporadaModels;
    }


    public boolean validarTime() {
        return nome != null && !nome.trim().isEmpty() &&
                descricao != null && descricao.length() >= 10 &&
                (sts == 'A' || sts == 'I') &&
                idTemporada > 0 &&
                idUsuario > 0;
    }


    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        if (nome == null || nome.trim().isEmpty())
            erros.append(" O campo 'Nome do time' está vazio. Por favor, informe um nome válido. ");

        if (descricao == null || descricao.length() < 10)
            erros.append(" A 'Descrição do time' deve conter no mínimo 10 caracteres para ser considerada válida. ");

        if (sts != 'A' && sts != 'I')
            erros.append(" O campo 'Status' está incorreto. Use 'A' para ativo ou 'I' para inativo. ");

        if (idTemporada <= 0)
            erros.append(" O 'ID da temporada' deve ser um número positivo maior que zero. ");

        if (idUsuario <= 0)
            erros.append(" O 'ID do usuário' responsável pelo time deve ser um número positivo. ");

        return erros.toString().trim();
    }


    public boolean validarData(LocalDate data) {
        return data != null && !data.isAfter(LocalDate.now());
    }


    public static LocalDate converterParaLocalDate(String dataStr, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(dataStr, formatter);
    }
}

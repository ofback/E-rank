package com.doback.E_rank.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Desafios {


    private int id;
    private String nome;
    private String descricao;
    private int pontos;
    private boolean punitivo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Desafios() {}

    public Desafios(String nome, String descricao, int pontos, boolean punitivo, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.pontos = pontos;
        this.punitivo = punitivo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getPontos() { return pontos; }

    public void setPontos(int pontos) { this.pontos = pontos; }

    public boolean isPunitivo() { return punitivo; }

    public void setPunitivo(boolean punitivo) { this.punitivo = punitivo; }

    public LocalDate getDataInicio() { return dataInicio; }

    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }

    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }


    public boolean validarDesafio() {
        return getErrosValidacao().isEmpty();
    }

    public String getErrosValidacao() {
        StringBuilder erros = new StringBuilder();

        List<String> palavrasProibidas = Arrays.asList("teste", "null", "desconhecido");
        long duracao = dataInicio != null && dataFim != null ? ChronoUnit.DAYS.between(dataInicio, dataFim) : -1;


        if (nome == null) {
            erros.append("Nome não pode ser nulo.\n");
        }


        if (descricao == null || descricao.trim().length() < 10) {
            erros.append("Descrição deve ter no mínimo 10 caracteres.\n");
        } else {
            for (String proibida : palavrasProibidas) {
                if (descricao.toLowerCase().contains(proibida)) {
                    erros.append("Descrição contém palavra proibida: ").append(proibida).append("\n");
                }
            }
        }


        if (!punitivo && pontos < 0) {
            erros.append("Somente desafios punitivos podem ter pontos negativos.\n");
        }


        if (dataInicio == null || dataFim == null) {
            erros.append("Data de início e fim não podem ser nulas.\n");
        } else {
            if (dataInicio.getDayOfWeek() == DayOfWeek.SATURDAY || dataInicio.getDayOfWeek() == DayOfWeek.SUNDAY) {
                erros.append("Desafios não podem começar no fim de semana.\n");
            }

            if (duracao < 2 || duracao > 30) {
                erros.append("Desafio deve durar entre 2 e 30 dias.\n");
            }
        }

        return erros.toString().trim();
    }
}
